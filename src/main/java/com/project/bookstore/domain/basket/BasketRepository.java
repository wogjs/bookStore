package com.project.bookstore.domain.basket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findByUsers_Id(String userid);
}
