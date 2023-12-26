package org.example.basicbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@EnableBatchProcessing
@SpringBootApplication
public class BasicBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BasicBatchApplication.class, args);
    }
}