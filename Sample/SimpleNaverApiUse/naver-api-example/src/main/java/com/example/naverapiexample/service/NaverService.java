package com.example.naverapiexample.service;

import com.example.naverapiexample.dto.BaseDto;
import com.example.naverapiexample.dto.NaverData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class NaverService {

    //https://openapi.naver.com/v1/search/local.json
    // ?query=%EA%B0%88%EB%B9%84%EC%A7%91
    // &display=10
    // &start=1
    // &sort=random

    public String search() {
        String query = "독서실";
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();

        log.info("uri : {}",uri);

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "rj1Db3V5PsXLsffG2v2a");
        headers.add("X-Naver-Client-Secret", "04ULRhmGQo");

        RequestEntity<Void> reqEntity = RequestEntity.get(uri)
                .headers(headers)
                .build();

        ResponseEntity<String> response = template.exchange(reqEntity,String.class);
        log.info("req : {}",reqEntity);
        log.info("res : {}",response);
        return response.getBody();
    }
}
