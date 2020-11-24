package com.project.bookstore.web.orders.dto;

import com.project.bookstore.domain.orders.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderListDto {
    private String isbn;
    private Long orderSum;

    public OrderListDto(Orders entity) {

    }
}
