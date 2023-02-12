package com.example.springbootvalidation.controller;

import com.example.springbootvalidation.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @PostMapping("/user")
    public Object user(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
