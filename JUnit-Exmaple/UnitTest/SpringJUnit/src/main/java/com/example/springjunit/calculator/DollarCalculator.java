package com.example.springjunit.calculator;

import com.example.springjunit.api.MarketApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("Dollar")
public class DollarCalculator implements ICalculator {
    private int price = 1;
    private final MarketApi api;

    @Override
    public void init() {
        this.price = api.dollar();
    }

    @Override
    public int sum(int x, int y) {
        x *= this.price;
        y *= this.price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= this.price;
        y *= this.price;
        return x - y;
    }
}
