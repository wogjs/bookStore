package com.project.bookstore.service.orders;

import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.domain.orders.OrdersRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private OrdersRepository ordersRepository;
    private BooksRepository booksRepository;

    // @Transactional
    // public List<OrderInsertDto> findBooks(String isbn) {

    // }
}
