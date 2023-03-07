package com.example.bookreview.domain.entity;

import com.example.bookreview.domain.listener.BookReviewListener;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private String title;

    private String content;

//    private float score;
//
//    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @ToString.Exclude
    private Book book;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_review_id")
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment... comment) {
        Collections.addAll(this.comments, comment);
    }
}
