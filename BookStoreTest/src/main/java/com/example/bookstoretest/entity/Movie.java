package com.example.bookstoretest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Data
@DiscriminatorColumn(name = "M")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Item {
    private String director;
    private String actor;
}
