package com.example.bookreview.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class BookReview extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private float score;
    private int count;
    private Long bookId;
    private Long userId;
}
