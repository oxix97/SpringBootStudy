package com.example.bookstoretest.repository;

import com.example.bookstoretest.entity.*;
import com.example.bookstoretest.service.OrderService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class OrderedRepositoryTest {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ItemRepository ir;
    @Autowired
    private MemberRepository mr;
    @Autowired
    private OrderService service;

    private Member createMember() {
        Member member = new Member();
        member.setName("Kim");
        member.setAddress(new Address("서울", "구로구", "18092"));
        mr.save(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        ir.save(book);
        return book;
    }

    @Test
    void 상품주문() {
        Member member = createMember();
        Item item = createBook("JPA", 10_000, 5);
        int orderCount = 2;

        Ordered ordered = service.order(member.getId(), item.getId(), orderCount);

        Assertions.assertEquals(OrderStatus.Ordered, ordered.getOrderStatus());
        Assertions.assertEquals(1, ordered.getOrderItems().size());
        Assertions.assertEquals(20_000, ordered.getTotalPrice());
        Assertions.assertEquals(3, item.getStockQuantity());
    }

    @Test
    void 주문취소() {
        Member member = createMember();
        Item item = createBook("JPA", 10_000, 5);
        int orderCount = 2;
        Ordered ordered = service.order(member.getId(), item.getId(), orderCount);

        service.cancelOrder(ordered.getId());
        Assertions.assertEquals(OrderStatus.NONE, ordered.getOrderStatus());
        Assertions.assertEquals(5, item.getStockQuantity());
    }
}