package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void persistTest() {
        repository.save(new Book("Boook", "Chan"));
        Assertions.assertNotNull(repository.findByName("Boook").getCreatedAt());
        Assertions.assertNotNull(repository.findByName("Boook").getUpdatedAt());
    }

    @Test
    void updateTest() {
        Book book = repository.findByName("Boook");
        book.setName("Khan");
        repository.save(book);
        Assertions.assertNotEquals(book.getCreatedAt(), book.getUpdatedAt());
    }

    @Test
    void printList() {
        repository.findAll().forEach(System.out::println);
    }
}