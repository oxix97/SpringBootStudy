package com.example.springjunit.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/api")
public class TestController {
    private final JPY jpy;
    private final USD usd;
    private final KRW krw;

    @GetMapping("/usd/sum")
    public float sumDollar(
            @RequestParam float x,
            @RequestParam float y
    ) {
        return usd.sum(x, y);
    }

    @GetMapping("/usd/min")
    public float minDollar(
            @RequestParam float x,
            @RequestParam float y
    ) {
        return usd.min(x, y);
    }

    @GetMapping("/usd/mul")
    public float mulDollar(
            @RequestParam float x,
            @RequestParam float y
    ) {
        return usd.mul(x, y);
    }

    @GetMapping("/usd/div")
    public float divDollar(
            @RequestParam float x,
            @RequestParam float y
    ) {
        return usd.div(x, y);
    }

    @GetMapping("/krw/mul")
    public float mulWon(
            @RequestParam float x,
            @RequestParam float y
    ) {
        return krw.mul(x, y);
    }
}
