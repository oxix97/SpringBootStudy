package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete-test")
public class DeleteApiController {

    //get이랑 동작 자체는 동일하지만
    // delete -> 리소스 삭제 이기 때문에 없는 것을 삭제 요청해도 request형식이 다르지 않는 이상 200이 나온다 -> 멱등성
    @DeleteMapping("/delete/{user-id}")
    public void deleteUser(
            @PathVariable(name = "user-id") int userId,
            @RequestParam String account
    ) {
        System.out.println("id : " + userId + " , account : " + account);
    }
}
