package com.example.springbootvalidation.controller;

import com.example.springbootvalidation.dto.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public Object user(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().forEach(error -> {
                FieldError field = (FieldError) error;
                String msg = error.getDefaultMessage();
                System.err.println("field : " + field.getField() + ", msg : " + msg);

                sb.append("field : ").append(field.getField())
                        .append(", message : ").append(msg);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        return user;
    }
}
