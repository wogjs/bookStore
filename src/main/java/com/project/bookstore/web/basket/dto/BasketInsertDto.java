package com.project.bookstore.web.basket.dto;

import com.project.bookstore.domain.basket.Basket;
import com.project.bookstore.domain.users.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BasketInsertDto {
    private Users users;

    public Basket toEntity() {
        return Basket.builder().users(users).build();
    }
}
