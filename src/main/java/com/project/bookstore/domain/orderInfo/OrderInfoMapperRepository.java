package com.project.bookstore.domain.orderInfo;

import java.util.List;

import com.project.bookstore.web.orders.dto.OrderListDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapperRepository {
    List<OrderListDto> getOrderList(Long order_code);
}
