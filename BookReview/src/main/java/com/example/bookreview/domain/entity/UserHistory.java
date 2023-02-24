package com.example.bookreview.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ForeignKey
    private Long userId;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
