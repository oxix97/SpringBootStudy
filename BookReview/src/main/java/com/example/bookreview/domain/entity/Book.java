package com.example.bookreview.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Book extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private String category;
//    @ForeignKey
    private Long authorId;
//    @ForeignKey
    private Long publisherId;
}
