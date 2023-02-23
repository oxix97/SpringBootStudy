package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.entity.BookReview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookReviewRepository reviewRepository;

    @Test
    void bookTest() {
        Book book = new Book(1L, 1L);
        bookRepository.save(book);
        bookRepository.findAll().forEach(System.out::println);
    }

    @Test
    void bookTest2() {
        Book book = new Book(1L, 1L);
        book.setName("BOOOOK");
        bookRepository.save(book);

        BookReview review = new BookReview();
        review.setBookId(1L);
        review.setScore(4.5F);
        review.setCount(2);
        reviewRepository.save(review);
        reviewRepository.findAll().forEach(System.out::println);
        Book result = bookRepository
                .findById(reviewRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBookId())
                .orElseThrow(RuntimeException::new);
        System.out.println(result);
    }
}