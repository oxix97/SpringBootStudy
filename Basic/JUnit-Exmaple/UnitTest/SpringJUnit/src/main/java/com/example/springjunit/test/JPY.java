package com.example.springjunit.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class JPY implements ICalc {
    private final Calc calc;
    private float rate = 0.1F;

    @Override
    public float sum(float x, float y) {
        return calc.sum(x, y) * rate;
    }

    @Override
    public float min(float x, float y) {
        return calc.min(x, y) * rate;
    }

    @Override
    public float mul(float x, float y) {
        return calc.mul(x, y) * rate;
    }

    @Override
    public float div(float x, float y) {
        return calc.div(x, y) * rate;
    }
}
