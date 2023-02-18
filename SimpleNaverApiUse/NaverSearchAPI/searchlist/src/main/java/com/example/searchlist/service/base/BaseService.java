package com.example.searchlist.service.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class BaseService {
    @Value("${client_id}")
    private String clientId;
    @Value("${client_secret}")
    private String clientSecret;
    @Value("${url_base}")
    private String baseUrl;

    public URI uriBuilder(MultiValueMap<String, String> query, String url) {
        return UriComponentsBuilder.fromUriString(baseUrl)
                .path(url)
                .queryParams(query)
                .encode()
                .build()
                .toUri();
    }

    public HttpHeaders baseHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        return headers;
    }
}
