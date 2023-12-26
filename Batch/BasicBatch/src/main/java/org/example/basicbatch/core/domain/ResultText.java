package org.example.basicbatch.core.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Slf4j
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "result_text")
@Entity
public class ResultText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    public static ResultText of(String text) {
        return new ResultText(null, text);
    }
}