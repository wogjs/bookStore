package com.project.bookstore.web.orders.dto;

import com.project.bookstore.domain.books.Books;
import com.project.bookstore.domain.orderInfo.MultiId;
import com.project.bookstore.domain.orderInfo.OrderInfo;
import com.project.bookstore.domain.orders.Orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoInsertDto {
    private MultiId multiId;
    private Long orderAmount;
    private Orders orders;
    private Books books;

    public OrderInfo toEntity() {
        return OrderInfo.builder()
            .multiId(multiId)
            .orderAmount(orderAmount)
            .orders(orders)
            .books(books)
            .build();
    }
}
