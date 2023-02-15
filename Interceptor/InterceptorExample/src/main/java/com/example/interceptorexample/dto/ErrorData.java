package com.example.interceptorexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorData {
    private int status;
    private boolean success;
    private String message;
}
