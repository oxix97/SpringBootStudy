package com.example.bookstoretest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookStoreTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreTestApplication.class, args);
    }

}
