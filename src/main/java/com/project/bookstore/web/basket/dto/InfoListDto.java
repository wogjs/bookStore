package com.project.bookstore.web.basket.dto;

import com.project.bookstore.domain.basket.Basket;
import com.project.bookstore.domain.basketInfo.BasketInfo;
import com.project.bookstore.domain.basketInfo.MultiId;
import com.project.bookstore.domain.books.Books;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InfoListDto {
    private MultiId multiId;
    private Long basAmount;
    private Basket basket;
    private Books books;

    public InfoListDto(BasketInfo entity) {
        this.multiId = entity.getMultiId();
        this.basAmount = entity.getBasAmount();
        this.basket = entity.getBasket();
        this.books = entity.getBooks();
    }
}
