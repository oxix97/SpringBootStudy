package com.example.springjunit.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class USD implements ICalc {
    private float rate = 1301.82F;
    private final Calc calc;

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
