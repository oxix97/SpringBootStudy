package com.example.aoptest.controller;

import com.example.aoptest.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get id : " + id + ", name : " + name);
    }

    @PostMapping("/post")
    public void post(@RequestBody User user) {
        System.out.println("post : "+user.toString());
    }
}
