package com.example.basic.jpa.manager.controller;

import com.example.basic.jpa.manager.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        User user = new User("n","a","a","a");
        return "hello";
    }
}
