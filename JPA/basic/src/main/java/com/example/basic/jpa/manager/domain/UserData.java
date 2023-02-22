package com.example.basic.jpa.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@SequenceGenerator(
//        name = "SEQ_GEN",
//        sequenceName = "BOARD_SEQ"
//)
public class UserData {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private LocalDateTime updatedAt;
}
