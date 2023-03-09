package com.example.securitytest.web.controller;

import com.example.securitytest.web.AnyController;
import com.example.securitytest.web.dto.SecurityMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiController implements AnyController {

    @RequestMapping("/")
    public String index() {
        return "home page";
    }

    @RequestMapping("/auth")
    public Authentication auth() {
        Authentication context = SecurityContextHolder.getContext().getAuthentication();
        log.info("info : {}", context);
        return context;
    }

    @Override
    @RequestMapping("/user")
    public SecurityMessage user() {
        return SecurityMessage.builder()
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .msg("user info")
                .build();
    }

    @Override
    @RequestMapping("/admin")
    public SecurityMessage admin() {
        return SecurityMessage.builder()
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .msg("admin info")
                .build();
    }

//    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
//    @GetMapping("/user")
//    public SecurityMessage user() {
//        return SecurityMessage.builder()
//                .auth(SecurityContextHolder.getContext().getAuthentication())
//                .msg("User info")
//                .build();
//    }
//
//    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
//    @RequestMapping("/admin")
//    public SecurityMessage admin() {
//        return SecurityMessage.builder()
//                .auth(SecurityContextHolder.getContext().getAuthentication())
//                .msg("admin info")
//                .build();
//    }
}
