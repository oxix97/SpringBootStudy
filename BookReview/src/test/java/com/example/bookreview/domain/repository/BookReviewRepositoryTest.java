package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.entity.BookReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookReviewRepository reviewRepository;

    @BeforeEach
    void init() {
        Book book = new Book();
        book.setName("JPA TEST");
//        book.setAuthor("CHan");
        book.setCategory("Spring");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);
        bookRepository.save(book);
    }

    @Test
    void bookReviewSaveTest() {
        BookReview review = new BookReview();
        review.setCount(1);
        review.setTitle("BBB");
        review.setUserId(1L);
        review.setScore(4.5F);
        review.setContent("이게 되네");
        review.setBookId(1L);
        System.out.println("books : " + review.getBook());
        reviewRepository.save(review);
        System.out.println(bookRepository.findAll());
    }
}