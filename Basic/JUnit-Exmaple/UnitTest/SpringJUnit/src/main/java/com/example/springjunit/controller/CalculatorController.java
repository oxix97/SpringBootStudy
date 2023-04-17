package com.example.springjunit.controller;

import com.example.springjunit.calculator.Calculator;
import com.example.springjunit.calculator.ICalculator;
import com.example.springjunit.dto.Number;
import com.example.springjunit.dto.Response;
import jakarta.servlet.annotation.HttpConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalculatorController {

    private final Calculator calculator;

    @GetMapping("/dollar/sum")
    public int sumDollar(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @PostMapping("/dollar/minus")
    public Response minusDollar(@RequestBody Number number) {
        int result = calculator.minus(number.getX(), number.getY());
        Response response = new Response();
        response.setResult(result);
        response.setBody(new Response.Body());
        return response;
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
