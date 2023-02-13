package com.example.bestpracticevalidation.advice;

import com.example.bestpracticevalidation.dto.ErrorData;
import com.example.bestpracticevalidation.dto.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println("------------");
        System.out.println(e.getClass().getName());
        System.out.println("------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<ErrorData> list = new ArrayList<>();
        ErrorData data = new ErrorData();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> {
            FieldError field = (FieldError) error;
            String fieldName = field.getField();
            String msg = field.getDefaultMessage();
            String value = field.getRejectedValue().toString();

            data.setField(fieldName);
            data.setMessage(msg);
            data.setInvalidValue(value);
            list.add(data);
        });

        ResponseError responseError = new ResponseError(list);
        responseError.setRequestUrl(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e) {
        List<ErrorData> errorList = new ArrayList<>();
        ErrorData data = new ErrorData();

        e.getConstraintViolations().forEach(error -> {
            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
            List<Path.Node> list = stream.toList();
            String field = list.get(list.size() - 1).getName();
            String msg = error.getMessage();
            String value = error.getInvalidValue().toString();
            data.setField(field);
            data.setMessage(msg);
            data.setInvalidValue(value);
            errorList.add(data);
        });

        ResponseError responseError = new ResponseError(errorList);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e) {
        List<ErrorData> errorList = new ArrayList<>();
        ErrorData data = new ErrorData();
        String fieldName = e.getParameterName();
        String fieldType = e.getParameterType();
        String value = e.getMessage();
        data.setField(fieldName);

        System.out.println(fieldName + "\n" + fieldType + "\n" + value);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
