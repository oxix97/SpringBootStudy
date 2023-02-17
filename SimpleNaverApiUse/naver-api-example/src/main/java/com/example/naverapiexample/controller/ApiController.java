package com.example.naverapiexample.controller;

import com.example.naverapiexample.dto.NaverData;
import com.example.naverapiexample.service.NaverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final NaverService service;

    @GetMapping("/naver")
    public String naver() {
        return service.search();
    }
}
