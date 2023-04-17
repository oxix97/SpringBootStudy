package com.example.bookstoretest.service;

import com.example.bookstoretest.entity.*;
import com.example.bookstoretest.repository.MemberRepository;
import com.example.bookstoretest.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemService service;

    public Ordered order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Item item = service.findByItemId(itemId);
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Ordered ordered = Ordered.createdOrder(member, delivery, orderItem);

        orderRepository.save(ordered);

        return ordered;
    }

    public void cancelOrder(Long orderId) {
        Ordered ordered = orderRepository.findById(orderId).orElseThrow();
        orderRepository.delete(ordered);
        ordered.cancel();
    }
}
