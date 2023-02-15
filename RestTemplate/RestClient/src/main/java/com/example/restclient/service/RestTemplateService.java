package com.example.restclient.service;

import com.example.restclient.dto.response.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    public ResponseUser hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);
        //CRUD For Object , CRUD For ResponseEntity
        //String result = template.getForObject(uri, String.class); -> String

        RestTemplate template = new RestTemplate();
        ResponseUser result = template.getForEntity(uri, ResponseUser.class).getBody();
        return result;
    }
}
