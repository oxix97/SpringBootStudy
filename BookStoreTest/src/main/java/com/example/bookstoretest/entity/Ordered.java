package com.example.bookstoretest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public static Ordered createdOrder(Member member, Delivery delivery, OrderItem... items) {
        Ordered ordered = new Ordered();
        ordered.setMember(member);
        ordered.setDelivery(delivery);
        for (OrderItem item : items) {

        }
        ordered.setOrderItems(Arrays.asList(items));
        ordered.setOrderStatus(OrderStatus.Ordered);
        ordered.setOrderDate(LocalDateTime.now());
        return ordered;
    }

    public void cancel() {
        if (this.delivery.getOrderStatus() == OrderStatus.Arrived) {
            throw new RuntimeException("이미 상품이 배송완료 입니다.");
        }
        this.setOrderStatus(OrderStatus.NONE);
        for (OrderItem item : this.orderItems) {
            item.cancel();
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem item : this.orderItems) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}