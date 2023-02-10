package com.example.aoptest.controller;

import com.example.aoptest.annotation.Timer;
import com.example.aoptest.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " | " + name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(1000L * 2);// db logic 1 sec 라고 가정
    }
}
