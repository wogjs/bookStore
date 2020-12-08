package com.project.bookstore.domain.basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findByUsers_IdOrderByBasCodeDesc(String userid);
}
