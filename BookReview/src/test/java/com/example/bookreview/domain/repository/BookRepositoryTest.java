package com.example.bookreview.domain.repository;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.repository.dto.BookStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookReviewRepository reviewRepository;

    @BeforeEach
    void init() {
        for (int i = 1; i <= 5; i++) {
            Book book = new Book();
            book.setName("Test " + i);
            book.setCategory("Book");
            book.setStatus(new BookStatus(100));
            bookRepository.save(book);
        }
    }

    @Test
    void pagingTest() {
        bookRepository.findBookNameAndCategory(PageRequest.of(0, 1)).forEach(book ->
                System.out.println(book.getCategory() + " : " + book.getName()));
    }

    @Test
    void queryTest() {
        List<Book> books = bookRepository.findAll();
        for (Book b : books) {
            b.setName("Don't Need Native");
        }
//        System.out.println("--------------------------");
        bookRepository.saveAll(books);
        System.out.println("--------------------------");
        System.out.println("count : " + bookRepository.updateNativeQuery("Need Native"));
        System.out.println("--------------------------");
    }

    @Test
    void converterTest() {
        bookRepository.findAll().forEach(System.out::println);
    }

//    @Test
//    void queryTest() {
//        bookRepository.findBookNameAndCategory().forEach(data ->
//                System.out.println(data.get(0) + " : " + data.get(1))
//        );
//    }

//    @Test
//    void bookTest() {
//        Book book = new Book(1L, 1L);
//        bookRepository.save(book);
//        bookRepository.findAll().forEach(System.out::println);
//    }

//    @Test
//    void bookTest2() {
//        Book book = new Book(1L, 1L);
//        book.setName("BOOOOK");
//        bookRepository.save(book);
//
//        BookReview review = new BookReview();
////        review.setBookId(1L);
//        review.setScore(4.5F);
//        review.setCount(2);
//        reviewRepository.save(review);
//        reviewRepository.findAll().forEach(System.out::println);
//        Book result = bookRepository
//                .findById(reviewRepository
//                        .findById(1L)
//                        .orElseThrow(RuntimeException::new)
//                        .getBookId())
//                .orElseThrow(RuntimeException::new);
//        System.out.println(result);
//    }
}