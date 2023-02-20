package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void crudTest() {
        repository.save(new UserData());
        System.out.println(repository.findAll());
    }
}