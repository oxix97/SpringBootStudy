package com.example.bookstoretest.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Ordered> ordereds = new ArrayList<>();

    @Embedded
    private Address address;

    public void addOrder(Ordered... ordereds) {
        Collections.addAll(this.ordereds, ordereds);
    }

}
