package com.project.bookstore.domain.orderInfo;

import com.project.bookstore.domain.orders.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

    OrderInfo findByOrders(Orders orders);
}
