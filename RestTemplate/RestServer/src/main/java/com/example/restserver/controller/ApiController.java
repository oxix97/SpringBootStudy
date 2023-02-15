package com.example.restserver.controller;


import com.example.restserver.dto.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiController {

    @GetMapping("/hello")
    public ResponseUser hello() {
        return new ResponseUser("Chan", 27);
    }
}
