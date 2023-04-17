package com.example.springjunit.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class KRW implements ICalc {
    private final Calc calc;

    @Override
    public float sum(float x, float y) {
        return calc.sum(x, y);
    }

    @Override
    public float min(float x, float y) {
        return calc.min(x, y);
    }

    @Override
    public float mul(float x, float y) {
        return calc.mul(x, y);
    }

    @Override
    public float div(float x, float y) {
        return calc.div(x, y);
    }
}
