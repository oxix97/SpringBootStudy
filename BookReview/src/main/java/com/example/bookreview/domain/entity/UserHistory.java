package com.example.bookreview.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class UserHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "user_key")
    private Long userId;
    @NonNull
    private String name;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;
}
