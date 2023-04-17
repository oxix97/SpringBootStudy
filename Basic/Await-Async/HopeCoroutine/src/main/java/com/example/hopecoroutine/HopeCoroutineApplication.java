package com.example.hopecoroutine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HopeCoroutineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopeCoroutineApplication.class, args);
    }

}
