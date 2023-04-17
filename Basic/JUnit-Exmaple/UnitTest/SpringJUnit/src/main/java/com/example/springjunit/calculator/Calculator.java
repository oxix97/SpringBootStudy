package com.example.springjunit.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Calculator {
    private final ICalculator iCalculator;

    public int sum(int x, int y) {
        iCalculator.init();
        return iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        iCalculator.init();
        return iCalculator.minus(x, y);
    }
}
