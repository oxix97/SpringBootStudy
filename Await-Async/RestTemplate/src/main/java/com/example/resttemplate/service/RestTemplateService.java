package com.example.resttemplate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    //http:localhost:8080/api/client/hello

    public String hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")
                .path("/api/client/hello")
                .encode()
                .build()
                .toUri();

        log.info("uri : {}", uri.toString());

        //http method를 다 지원한다. CRUD_FOR_(object or entity)
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(uri, String.class);



        return result;
    }
}
