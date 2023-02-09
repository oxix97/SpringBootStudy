package com.example.test.controller;

import com.example.test.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    //TEXT -> 이런 형식은 거의 쓰지 않는다.
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //JSON request 오게 되면 object mapper -> obejct -> method -> obejct mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        System.out.println(user.toString());
        return user;
    }
}
