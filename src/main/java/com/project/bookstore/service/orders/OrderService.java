package com.project.bookstore.service.orders;

import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.domain.orders.OrdersRepository;
import com.project.bookstore.web.book.dto.BookListDto;
import com.project.bookstore.web.orders.dto.OrderInsertDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private OrdersRepository ordersRepository;
    private BooksRepository booksRepository;

    @Transactional
    public List<OrderInsertDto> findBooks(String isbn) {

    }
}
