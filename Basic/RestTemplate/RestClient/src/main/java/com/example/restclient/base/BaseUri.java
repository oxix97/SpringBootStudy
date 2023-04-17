package com.example.restclient.base;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class BaseUri {
    private static final String baseUri = "http://localhost:9090";
    public static URI uri(String path) {
        return UriComponentsBuilder
                .fromUriString(baseUri)
                .path(path)
                .encode()
                .build()
                .toUri();

    }

    public static URI uri(String path, String query) {
        return UriComponentsBuilder
                .fromUriString(baseUri)
                .queryParam(query)
                .path(path)
                .encode()
                .build()
                .toUri();

    }
}
