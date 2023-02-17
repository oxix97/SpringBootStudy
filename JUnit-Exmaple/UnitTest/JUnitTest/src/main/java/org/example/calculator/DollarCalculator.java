package org.example.calculator;

import org.example.api.MarketApi;

public class DollarCalculator implements ICalculator {
    private int price = 1;

    public DollarCalculator(MarketApi api) {
        this.price = api.connect();
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
