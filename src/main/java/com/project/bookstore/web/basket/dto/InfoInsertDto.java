package com.project.bookstore.web.basket.dto;

import com.project.bookstore.domain.basket.Basket;
import com.project.bookstore.domain.basketInfo.BasketInfo;
import com.project.bookstore.domain.basketInfo.MultiId;
import com.project.bookstore.domain.books.Books;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoInsertDto {
    private MultiId multiId;
    private Long basAmount;
    private Books books;
    private Basket basket;

    public BasketInfo toEntity() {
        return BasketInfo.builder()
            .multiId(multiId)
            .basAmount(basAmount)
            .books(books)
            .basket(basket)
            .build();
    }
}
