package com.example.bestpracticevalidation.controller;

import com.example.bestpracticevalidation.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/user")
    public User getUser(
            @Size(min = 2)
            @RequestParam String name,
            @NotNull
            @Min(value = 1)
            @Max(value = 90)
            @RequestParam Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/post")
    public User postUser(@Valid @RequestBody User user) {
        return user;
    }

}
