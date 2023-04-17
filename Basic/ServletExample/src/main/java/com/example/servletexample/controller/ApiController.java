package com.example.servletexample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/home/room")
    public String getRoom() {
        return "room";
    }

    @GetMapping("/company")
    public String getCompany() {
        return "company";
    }
}
