package com.example.springjunit.controller;

import com.example.springjunit.calculator.Calculator;
import com.example.springjunit.calculator.ICalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalculatorController {

    private final Calculator calculator;

    @GetMapping("/dollar/sum")
    public int sumDollar(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @GetMapping("/dollar/minus")
    public int minusDollar(@RequestParam int x, @RequestParam int y) {
        return calculator.minus(x, y);
    }

//    @Qualifier("krw")
//    @GetMapping("/krw/sum")
//    public int sumKrw(@RequestParam int x, @RequestParam int y) {
//        return calculator.sum(x, y);
//    }
//
//    @Qualifier("krw")
//    @GetMapping("/krw/minus")
//    public int minusKrw(@RequestParam int x, @RequestParam int y) {
//        return calculator.minus(x, y);
//    }
}
