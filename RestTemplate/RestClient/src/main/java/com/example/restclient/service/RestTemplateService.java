package com.example.restclient.service;

import com.example.restclient.base.BaseEntity;
import com.example.restclient.base.BaseUri;
import com.example.restclient.dto.request.Req;
import com.example.restclient.dto.request.RequestUser;
import com.example.restclient.dto.response.ResponseUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

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
        log.info("result : {}", result);
        return result;
    }

    //http:localhost:9090/api/server/user/{userId}
    public ResponseUser post() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user")
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);

        //http body -> obejct -> object mapper -> json -> ...
        RestTemplate template = new RestTemplate();
        RequestUser user = new RequestUser("aaaaa", 100);

        RequestEntity<RequestUser> request = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "head")
                .body(user);

        ResponseEntity<ResponseUser> response = template.exchange(request, ResponseUser.class);

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

    public ResponseUser genericExchange() {
        RequestUser request = new RequestUser("SSSSSSS", 1111);
        URI uri = BaseUri.uri("/api/server/exchange");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "auth");
        headers.add("Custom", "custom");

        Req<RequestUser> req = new Req<>();
        req.setHeaders(headers);
        req.setResponseBody(request);

        RestTemplate template = new RestTemplate();

        BaseEntity<RequestUser, ResponseUser> entity = new BaseEntity<>();
        RequestEntity<RequestUser> reqEntity = entity.requestEntity(uri, req.getHeaders(), req.getResponseBody());
        ResponseEntity<ResponseUser> resEntity = template.exchange(reqEntity, new ParameterizedTypeReference<ResponseUser>() {});

        return resEntity.getBody();
    }
}
