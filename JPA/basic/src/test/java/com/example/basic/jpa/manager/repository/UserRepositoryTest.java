package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@WebAppConfiguration
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void crudTest() {
        repository.findAll().forEach(System.err::println);
    }
}