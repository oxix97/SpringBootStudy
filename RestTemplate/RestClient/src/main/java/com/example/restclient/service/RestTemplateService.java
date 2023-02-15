package com.example.restclient.service;

import com.example.restclient.dto.request.RequestUser;
import com.example.restclient.dto.response.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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
                .queryParam("name", "Chan")
                .queryParam("age", 111)
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

    //http:localhost:9090/api/server/user/{userId}
    public ResponseUser post() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{name}/age/{age}")
                .encode()
                .build()
                .expand("Chan", 27)
                .toUri();
        log.info("uri : {}", uri);

        //http body -> obejct -> object mapper -> json -> ...
        RestTemplate template = new RestTemplate();
        RequestUser req = new RequestUser("aaaaa", 100);
        ResponseEntity<ResponseUser> response = template.postForEntity(uri, req, ResponseUser.class);

        log.info("response status : {}", response.getStatusCode());
        log.info("response body : {}", response.getBody());

        return response.getBody();
    }

    public ResponseUser exchange() {
        RequestUser req = new RequestUser("ACON", 1111);
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/exchange/{name}/age/{age}")
                .encode()
                .build()
                .expand(req.getName(), req.getAge())
                .toUri();
        log.info("uri : {}", uri);

        //http body -> obejct -> object mapper -> json -> ...
        RestTemplate template = new RestTemplate();
        RequestEntity<RequestUser> reqEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "asdf")
                .body(req);

        ResponseEntity<ResponseUser> response = template.exchange(reqEntity, ResponseUser.class);
        return response.getBody();

    }
}
