package com.example.basicloginauthentication.controller;

import com.example.basicloginauthentication.domain.SecurityMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String test() {
        return "alkdjflkajf";
    }

    @RequestMapping("/auth")
    public Authentication auth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @RequestMapping("/user")
    public SecurityMessage user() {
        return SecurityMessage.of(
                SecurityContextHolder.getContext().getAuthentication(),
                "유저 입니다."
        );
    }

    @RequestMapping("/admin")
    public SecurityMessage admin() {
        return SecurityMessage.of(
                SecurityContextHolder.getContext().getAuthentication(),
                "관리자 입니다."
        );
    }
}
