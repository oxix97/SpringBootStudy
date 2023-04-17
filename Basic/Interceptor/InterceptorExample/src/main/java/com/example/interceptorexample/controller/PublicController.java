package com.example.interceptorexample.controller;

import com.example.interceptorexample.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {
    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        return new User(name, age);
    }
}
