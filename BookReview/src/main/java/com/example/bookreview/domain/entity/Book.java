package com.example.bookreview.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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
}
