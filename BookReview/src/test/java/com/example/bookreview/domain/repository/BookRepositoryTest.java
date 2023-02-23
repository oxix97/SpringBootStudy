package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void bookTest() {
        Book book = new Book(1L, 1L);
        repository.save(book);
        repository.findAll().forEach(System.out::println);
    }
}