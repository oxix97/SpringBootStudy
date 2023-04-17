package com.example.interceptorexample.controller;

import com.example.interceptorexample.annotation.Auth;
import com.example.interceptorexample.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Slf4j
@Auth
public class PrivateController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        return new User(name, age);
    }
}
