package com.example.bookstoretest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Data
@DiscriminatorColumn(name = "B")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Item {
    private String author;
    private String isbn;
}
