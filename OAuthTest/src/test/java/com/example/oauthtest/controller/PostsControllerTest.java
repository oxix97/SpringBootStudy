package com.example.oauthtest.controller;

import com.example.oauthtest.config.auth.dto.PostsSaveRequestDto;
import com.example.oauthtest.repository.PostsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.AfterTestClass;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PostsRepository repository;

    @AfterTestClass
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    void 등록() throws Exception{
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto
                .builder()
                .title(title)
                .content(content)
                .author("author")
                .build();
        String url = "http://localhost:"+port+"/api/v1/post";

        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url,requestDto,Long.class);

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}