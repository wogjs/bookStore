package com.project.bookstore.web.orders.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderListDto {
    private String isbn;
    private Long orderSum;

}
