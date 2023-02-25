package com.example.bookreview.domain.entity;

import com.example.bookreview.domain.listener.BookReviewListener;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;

    private String category;
    //    @ForeignKey
    @NonNull
    private Long authorId;
    //    @ForeignKey
    @NonNull
    private Long publisherId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_key", insertable = false, updatable = false)
    private List<BookReview> reviews = new ArrayList<>();
}
