package com.example.bookreview.domain.entity;

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
public class Author extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    //    @NonNull
    private String name;

    private Integer country;

    //    @ForeignKey
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();

    public void addBook(Book... book) {
        Collections.addAll(this.books, book);
    }
}
