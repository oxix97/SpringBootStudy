package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.BookHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookHistoryRepositoryTest {

    @Autowired
    private BookHistoryRepository repository;

    @Test
    void auditingTest() {
        BookHistory data = new BookHistory("Book", "Chan");
        repository.save(data);
        data.setName("BBBBOOOOKKK");
        repository.save(data);
        System.out.println(repository.findByName("BBBBOOOOKKK"));
    }
}