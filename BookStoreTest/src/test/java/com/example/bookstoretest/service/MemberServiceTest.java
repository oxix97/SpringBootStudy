package com.example.bookstoretest.service;

import com.example.bookstoretest.entity.Member;
import com.example.bookstoretest.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    private MemberRepository repository;
    @Autowired
    private MemberService service;

    @Test
    void joinTest() throws Exception {
        Member member = new Member();
        member.setName("KiM");

        Long saveId = service.join(member);

        Assertions.assertEquals(member, repository.findById(saveId).orElse(null));
    }

    @Test
    void test1() {

    }

}