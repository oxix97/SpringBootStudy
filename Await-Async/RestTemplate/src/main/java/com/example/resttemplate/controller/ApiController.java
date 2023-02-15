package com.example.resttemplate.controller;

import com.example.resttemplate.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ApiController {

    private final RestTemplateService service;

    @GetMapping("/hello")
    public String getHello() {
        return service.hello();
    }
}
