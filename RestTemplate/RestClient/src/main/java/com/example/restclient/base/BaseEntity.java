package com.example.restclient.base;

import com.example.restclient.dto.request.Req;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
@Slf4j
public class BaseEntity<T, K> {
    private Req<T> t;
    private Req<K> k;

    public RequestEntity<T> requestEntity(URI uri, HttpHeaders headers, T body) {

        return RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(headers)
                .body(body);
    }
}

