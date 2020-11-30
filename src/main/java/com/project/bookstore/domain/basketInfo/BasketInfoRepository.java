package com.project.bookstore.domain.basketInfo;

import java.util.List;

import com.project.bookstore.domain.basket.Basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketInfoRepository extends JpaRepository<BasketInfo, Long> {

    List<BasketInfo> findByBasket(Basket basket);
}
