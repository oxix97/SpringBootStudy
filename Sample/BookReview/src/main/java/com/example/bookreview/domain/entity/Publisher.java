package com.example.bookreview.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Publisher extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Book> books;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Author> authors;
}
