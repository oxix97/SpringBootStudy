package com.example.searchlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverServiceTest {
    @Autowired
    private NaverService service;

    @Test
    public void searchTest() {
        var result = service.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}
