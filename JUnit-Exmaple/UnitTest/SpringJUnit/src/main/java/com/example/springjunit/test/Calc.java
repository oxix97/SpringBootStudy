package com.example.springjunit.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class Calc {

    public float sum(float x, float y) {
        return x + y;
    }

    public float min(float x, float y) {
        return x - y;
    }

    public float mul(float x, float y) {
        return x * y;
    }

    public float div(float x, float y) {
        return x / y;
    }
}
