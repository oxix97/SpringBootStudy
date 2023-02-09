package com.example.test.controller;

import com.example.test.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //put의 경우 200,201을 모두 사용한다. 201에 대한 대응 예시
    //put use update -> 200
    //put use create -> 201
    //응답에 대해 customizing 하는 경우 ResponseEntity를 사용하면 된다.
    @PutMapping("/put-test")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
