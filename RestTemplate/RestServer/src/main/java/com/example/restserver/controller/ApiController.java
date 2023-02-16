package com.example.restserver.controller;


import com.example.restserver.dto.Req;
import com.example.restserver.dto.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ApiController {

    @GetMapping("/hello")
    public ResponseUser hello(@RequestParam String name, @RequestParam int age) {
        return new ResponseUser(name, age);
    }

    @PostMapping("/exchange/{name}/age/{age}")
    public Req<ResponseUser> exchange(
//            HttpEntity<String> entity,
            @RequestBody Req<ResponseUser> user,
            @PathVariable String name,
            @PathVariable int age,
            @RequestHeader("Authorization") String auth
    ) {
        log.info("header : {}", user.getHeader());
        log.info("header : {}", user.getResponseBody());

        Req<ResponseUser> response = new Req<>();
        response.setHeader(user.getHeader());
        response.setHeader(new Req.Header(auth));
        response.setResponseBody(user.getResponseBody());
        return response;
    }

    @PostMapping("/user")
    public ResponseUser user(
            @RequestHeader("Authorization") String auth,
            @RequestBody ResponseUser user
    ) {
        log.info("header : {}", auth);
        log.info("body : {}", user);
        return user;
    }

    @PostMapping("/exchange")
    public ResponseUser genericExchange(
            @RequestHeader HttpHeaders headers,
            @RequestBody ResponseUser user
    ) {
        log.info("header : {}", headers);
        log.info("body : {}", user);
        return user;
    }

}
