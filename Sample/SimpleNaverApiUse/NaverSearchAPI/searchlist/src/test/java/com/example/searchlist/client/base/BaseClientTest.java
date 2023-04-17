package com.example.searchlist.client.base;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseClientTest {
    @Resource(lookup = "client_id")
    private String id;
    @Resource(lookup = "client_secret")
    private String secret;
    @Resource(lookup = "url_base")
    private String baseUrl;

    @Test
    public void test() {

    }
}
