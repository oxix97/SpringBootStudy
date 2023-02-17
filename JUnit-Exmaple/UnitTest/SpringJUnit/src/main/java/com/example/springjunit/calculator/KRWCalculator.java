package com.example.springjunit.calculator;

import com.example.springjunit.api.MarketApi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KRWCalculator implements ICalculator {

    private int price = 1;

    @Override
    public void init() {
        this.price = 1;
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
