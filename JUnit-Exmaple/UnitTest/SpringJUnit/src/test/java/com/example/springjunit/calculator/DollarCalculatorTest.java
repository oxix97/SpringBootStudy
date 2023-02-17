package com.example.springjunit.calculator;

import com.example.springjunit.api.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DollarCalculatorTest {
    @MockBean
    private MarketApi api;

    @Autowired
    private DollarCalculator calculator;

    @Test
    public void dollarCalculatorTest() {
        Mockito.when(api.dollar()).thenReturn(3000);
        calculator.init();

        int sum = calculator.sum(10, 10);
        Assertions.assertEquals(60000, sum);

        int minus = calculator.minus(20, 10);
        Assertions.assertEquals(30000, minus);
    }



}
