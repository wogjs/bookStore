package com.project.bookstore.web.orders.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SumDto {
    private String isbn;
    private Long orderSum;

    public SumDto(String isbn, Long orderSum) {
        this.isbn = isbn;
        this.orderSum = orderSum;
    }
}
