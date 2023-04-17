package com.example.bookreview.domain.listener;

import com.example.bookreview.domain.entity.Book;
import com.example.bookreview.domain.entity.BookReview;
import com.example.bookreview.domain.repository.BookRepository;
import com.example.bookreview.util.BeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class BookReviewListener {
    @PostPersist
    @PostUpdate
    void persistAndPostGetReviews(Object obj) {
//        BookRepository repository = BeanUtils.getBean(BookRepository.class);
//        BookReview review = (BookReview) obj;
//        Book book = repository.findById(review.getBookId()).orElseThrow();
//        book.getReviews().add(review);
//        repository.save(book);
    }
}
