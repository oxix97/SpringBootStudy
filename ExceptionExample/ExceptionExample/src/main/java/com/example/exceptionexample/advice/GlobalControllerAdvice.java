package com.example.exceptionexample.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println("-----------global Exception----------");
        System.out.println("msg : " + e.getLocalizedMessage());
        System.out.println("---------------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((""));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("-----------global MethodArgumentNotValid----------");
        System.out.println("msg : " + e.getLocalizedMessage());
        System.out.println("---------------------------");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
