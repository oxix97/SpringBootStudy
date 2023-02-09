package com.example.aoptest.controller;

import com.example.aoptest.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id +" | "+ name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }
}
