package com.example.hello.controller;

import com.example.hello.dto.UserInfoReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/post-test")
public class PostApiController {

    @PostMapping("/json-test")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) ->
                System.out.println("key : " + key + " , value : " + value)
        );
    }

    //GET Mapping 같은 경우는 객체를 사용할 때 어노테이션을 붙이지 않아도 상관없었지만
    //POST 는 @RequestBody를 사용해야지만 값을 받아올 수 있습니다.
    @PostMapping("/user-info")
    public UserInfoReq postUserInfo(@RequestBody UserInfoReq userInfoData) {
        return userInfoData;
    }
}
