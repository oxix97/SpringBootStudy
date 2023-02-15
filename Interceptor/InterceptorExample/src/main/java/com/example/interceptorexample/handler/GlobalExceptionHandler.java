package com.example.interceptorexample.handler;

import com.example.interceptorexample.dto.ErrorData;
import jakarta.security.auth.message.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity authException() {
        ErrorData data = new ErrorData(
                HttpStatus.UNAUTHORIZED.value(),
                false,
                "미인증 사용자입니다."
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(data);
    }
}
