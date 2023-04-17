package com.example.bookstoretest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class ResponseData<T> {
    private int status;
    private Boolean success;
    private String message;
    private T data;
}
