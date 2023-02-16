package com.example.restclient.base;

import com.example.restclient.dto.request.Req;
import com.example.restclient.dto.response.ResponseUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BaseResponseEntity<T, K> {
    private T t;
    private K k;

    private final RestTemplate template = new RestTemplate();
}
