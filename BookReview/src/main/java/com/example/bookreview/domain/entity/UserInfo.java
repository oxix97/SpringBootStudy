package com.example.bookreview.domain.entity;

import com.example.bookreview.domain.listener.UserHistoryListener;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@EntityListeners(value = UserHistoryListener.class)
@Entity
public class UserInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
