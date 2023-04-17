package com.example.basic.jpa.manager.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
//        User user = new User("n", "a", LocalDateTime.now(), LocalDateTime.now());
        return "hello";
    }
}
