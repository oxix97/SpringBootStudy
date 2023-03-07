package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.entity.BookReview;
import com.example.bookreview.domain.entity.Comment;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookReviewRepository reviewRepository;

    @BeforeEach
    void init() {
        BookReview[] reviews = new BookReview[3];

        for (int i = 0; i < 3; i++) {
            reviews[i] = new BookReview();
            Comment comment = new Comment();
            comment.setComment("Commmmment");
            reviews[i].addComment(comment);
        }
        Comment c1 = new Comment();
        c1.setComment("c1c1c1");
        reviews[1].addComment(c1);

        reviewRepository.saveAll(Arrays.asList(reviews));
    }

    @Transactional
    @Test
    void reviewTest() {
        System.out.println("-------------");
        System.out.println(reviewRepository.findAll());
    }
}