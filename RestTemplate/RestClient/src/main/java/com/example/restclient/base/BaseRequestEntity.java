package com.example.restclient.base;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

import java.net.URI;

public class BaseRequestEntity<T> {
    private T t;
    public RequestEntity<T> requestEntity(URI uri, T body) {
        return RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "asdf")
                .body(body);
    }
}

