package com.example.hopecoroutine.controller;

import com.example.hopecoroutine.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final AsyncService service;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        log.info("init completableFuture");
        service.run();
        log.info("hello");
        return "hello";
    }
}
