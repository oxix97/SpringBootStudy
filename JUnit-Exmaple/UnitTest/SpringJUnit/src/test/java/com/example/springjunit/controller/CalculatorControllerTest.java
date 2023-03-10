package com.example.springjunit.controller;

import com.example.springjunit.api.MarketApi;
import com.example.springjunit.calculator.Calculator;
import com.example.springjunit.calculator.DollarCalculator;
import com.example.springjunit.dto.Number;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorControllerTest {
    @MockBean
    private MarketApi api;

    @BeforeEach
    public void init() {
        Mockito.when(api.dollar()).thenReturn(3000);
    }

    @Autowired
    private MockMvc mvc;

    @Test
    public void sumTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/dollar/sum")
                        .queryParam("x", "10")
                        .queryParam("y", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("60000"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void minusTest() throws Exception {
        Number number = new Number(10, 10);

        String json = new ObjectMapper().writeValueAsString(number);

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/dollar/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.resultCode").value("OK"))
                .andDo(MockMvcResultHandlers.print());
    }
}
