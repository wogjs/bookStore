package com.project.bookstore.service.orders;

import java.util.ArrayList;
import java.util.List;

import com.project.bookstore.domain.orderInfo.MultiId;
// import com.project.bookstore.domain.orderInfo.OrderInfo;
import com.project.bookstore.domain.orderInfo.OrderInfoMapperRepository;
import com.project.bookstore.domain.orderInfo.OrderInfoRepository;
import com.project.bookstore.domain.orders.Orders;
import com.project.bookstore.domain.orders.OrdersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.orders.dto.InfoInsertDto;
import com.project.bookstore.web.orders.dto.OrderDto;
import com.project.bookstore.web.orders.dto.OrderListDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final OrderInfoRepository infoRepository;
    private final OrderInfoMapperRepository mapperRepository;

    private final UserInfo userInfo;

    // 주문
    @Transactional
    public void orderInsert(OrderDto insertDto) {
        ordersRepository.save(insertDto.toEntity());
    }

    // 주문 상세 
    @Transactional
    public void infoInsert(String isbn, InfoInsertDto insertDto) {
        MultiId multiId = new MultiId();
        multiId.setIsbn(isbn);
        multiId.setOrderCode(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(userInfo.getUserId()).get(0).getOrderCode());
        insertDto.setMultiId(multiId);
        insertDto.setOrders(ordersRepository.findByUsers_IdOrderByOrderCodeDesc(userInfo.getUserId()).get(0));
        infoRepository.save(insertDto.toEntity());
    }

    // 주문 리스트
    @Transactional
    public List<OrderListDto> listRead() {
        List<OrderListDto> orderListDto = new ArrayList<OrderListDto>();
        List<Orders> orders = ordersRepository.findByUsers_IdOrderByOrderCodeDesc(userInfo.getUserId());
        for (int i =0; i < orders.size(); i++) {
            List<OrderListDto> listDto = mapperRepository.getOrderList(orders.get(i).getOrderCode());
            
            orderListDto.add(listDto.get(0));
        }
        return orderListDto;
    }
    
}
