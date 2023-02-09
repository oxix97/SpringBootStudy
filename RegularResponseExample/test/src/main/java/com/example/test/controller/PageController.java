package com.example.test.controller;

import com.example.test.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {


    //page return 하는 메서드
    // return type String -> 자동으로 html파일을 찾아서 return 한다 -> @Controller의 역할
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    //ResponseEntity
    @ResponseBody // -> 객체를 만드는 것이 아닌 ResponseBody를 만들어 내보내겠다는 어노테이션
    @GetMapping("/user")
    public User user() {
        var user = new User();
        user.setName("KKK");
        user.setAddress("SEOUL");
        return user;
    }
}
