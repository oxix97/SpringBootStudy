package com.example.bookstoretest.controller;

import com.example.bookstoretest.dto.OrderData;
import com.example.bookstoretest.entity.Ordered;
import com.example.bookstoretest.service.ItemService;
import com.example.bookstoretest.service.MemberService;
import com.example.bookstoretest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @PutMapping("/item")
    public OrderData postOrder(
            @RequestParam Long memberId,
            @RequestParam Long itemId,
            @RequestParam int count
    ) {
        Ordered order = orderService.order(memberId, itemId, count);
        return entityToDto(order);
    }

    private OrderData entityToDto(Ordered ordered) {
        var items = ordered.getOrderItems().stream().map(it -> it.getItem().getName()).toList();
        return OrderData.builder()
                .memberName(ordered.getMember().getName())
                .items(items)
                .address(ordered.getMember().getAddress())
                .build();
    }
}
