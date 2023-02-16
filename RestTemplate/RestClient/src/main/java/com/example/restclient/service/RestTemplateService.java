package com.example.restclient.service;

import com.example.restclient.dto.request.Req;
import com.example.restclient.dto.request.RequestUser;
import com.example.restclient.dto.response.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
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

    public Req<ResponseUser> genericExchange() {
        RequestUser request = new RequestUser("ACON", 1111);
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/exchange/{name}/age/{age}")
                .encode()
                .build()
                .expand(request.getName(), request.getAge())
                .toUri();
        log.info("uri : {}", uri);

        Req<RequestUser> req = new Req<>();
        req.setHeader(new Req.Header());
        req.setResponseBody(request);

        //http body -> obejct -> object mapper -> json -> ...
        RestTemplate template = new RestTemplate();
        RequestEntity<Req<RequestUser>> reqEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "asdf")
                .body(req);

        //제네릭에는 클래스를 사용할 수 없다.
        ResponseEntity<Req<ResponseUser>> response =
                template.exchange(reqEntity, new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}
