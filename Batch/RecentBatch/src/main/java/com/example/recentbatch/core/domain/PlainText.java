package com.example.recentbatch.core.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

@Slf4j
@ToString
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "plain_text")
public class PlainText {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    private PlainText(String text) {
        this.id = null;
        this.text = text;
    }

    public static PlainText of(String text) {
        return new PlainText(text);
    }
}
