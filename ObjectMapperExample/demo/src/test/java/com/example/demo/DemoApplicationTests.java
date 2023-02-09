package com.example.demo;

import com.example.demo.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello");
    }

    // object mapper?
    // Text Json -> Object
    // Object -> Text Json
    // controller -> reqest json(text) -> object
    // response object -> json(text)
    @Test
    void objectMapperExam() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();

        //todo object -> text
        // 해당 작업을 실행하는 경우 object mapper는 getter를 사용하는 것을 알 수 있다.(안쓰면 에러)

        System.out.println("------object -> text------");
        var user = new User("lee", 10,"010-123-1234");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // todo text -> object
        //  해당 작업을 실행하는 경우 object mapper는 기본 생성자를 사용하는 것을 알 수 있다.(안쓰면 에러남)

        System.out.println("------text -> object------");
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }
}
