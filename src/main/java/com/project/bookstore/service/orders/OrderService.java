package com.project.bookstore.service.orders;

import com.project.bookstore.domain.orderInfo.MultiId;
import com.project.bookstore.domain.orderInfo.OrderInfoRepository;
import com.project.bookstore.domain.orders.OrdersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.orders.dto.InfoInsertDto;
import com.project.bookstore.web.orders.dto.OrderDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final OrderInfoRepository infoRepository;

    private final UserInfo userInfo;

    // 주문
    @Transactional
    public void orderInsert(OrderDto insertDto) {
        ordersRepository.save(insertDto.toEntity());
    }

    // 주문리스트 
    @Transactional
    public void infoInsert(String isbn, InfoInsertDto insertDto) {
        MultiId multiId = new MultiId();
        multiId.setIsbn(isbn);
        multiId.setOrderCode(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(userInfo.getUserId()).get(0).getOrderCode());
        insertDto.setMultiId(multiId);
        insertDto.setOrders(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(userInfo.getUserId()).get(0));
        infoRepository.save(insertDto.toEntity());
    }
    
}
