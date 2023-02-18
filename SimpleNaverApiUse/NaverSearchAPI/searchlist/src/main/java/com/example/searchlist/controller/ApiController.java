package com.example.searchlist.controller;

import com.example.searchlist.dto.WishListDto;
import com.example.searchlist.service.NaverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {

    private final NaverService service;

    @GetMapping("/naver/search")
    public WishListDto naverSearch(@RequestParam String query) {
        return service.search(query);
    }
}
