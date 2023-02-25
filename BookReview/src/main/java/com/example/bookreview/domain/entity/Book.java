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
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    private String category;
    //    @ForeignKey
//    @NonNull
    private Long authorId;
    //    @ForeignKey
//    @NonNull
    @ManyToOne
    @ToString.Exclude
    private Publisher publisher;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_key", insertable = false, updatable = false)
    private List<BookReview> reviews = new ArrayList<>();

    public void addAuthor(Author... author) {
        Collections.addAll(this.authors, author);
    }
}
