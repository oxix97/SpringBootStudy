package com.example.restclient.controller;

import com.example.restclient.dto.request.Req;
import com.example.restclient.dto.response.ResponseUser;
import com.example.restclient.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ApiController {
    private final RestTemplateService service;

    @GetMapping("/hello")
    public ResponseUser hello() {
        return service.hello();
    }

    @GetMapping("/user")
    public ResponseUser user() {
        return service.post();
    }

//    @GetMapping("/exchange")
//    public ResponseUser exchange() {
//        return service.exchange();
//    }

    @GetMapping("/exchange")
    public ResponseUser exchange() {
        return service.genericExchange();
    }
}
