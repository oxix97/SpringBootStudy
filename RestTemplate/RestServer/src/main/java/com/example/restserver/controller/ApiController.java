package com.example.restserver.controller;


import com.example.restserver.dto.ResponseUser;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiController {

    @GetMapping("/hello")
    public ResponseUser hello(@RequestParam String name, @RequestParam int age) {
        return new ResponseUser(name, age);
    }

    @PostMapping("/user/{name}/age/{age}")
    public ResponseUser user(
            @RequestBody ResponseUser user,
            @PathVariable String name,
            @PathVariable int age
    ) {
        log.info("name : {}, age : {}",name,age);
        log.info("user : {}",user);
        return user;
    }
}
