package com.example.bookreview.domain.entity;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private int country;

//    @ForeignKey
    private Long bookId;
}
