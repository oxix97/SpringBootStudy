package com.example.bookreview.domain.entity;

import com.example.bookreview.domain.listener.BookReviewListener;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(BookReviewListener.class)
public class BookReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "user_key")
    private Long userId;

    @NonNull
    @Column(name = "book_key")
    private Long bookId;

    private String title;

    private String content;

    private float score;

    private int count;

    @ManyToOne
    @JoinColumn
    @ToString.Exclude
    private Book book;
}
