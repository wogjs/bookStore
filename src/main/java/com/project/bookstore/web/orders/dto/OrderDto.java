package com.project.bookstore.web.orders.dto;

import com.project.bookstore.domain.orders.Orders;
import com.project.bookstore.domain.users.Users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Users users;
    private Long addrCode;
    private Long orderSum;
    private Long orderZip;
    private String orderBas;
    private String orderDet;
    private String cardNum;
    private String cardVal;
    private String cardPeriod;
    
    public Orders toEntity() {
        return Orders.builder()
            .users(users)
            .orderSum(orderSum)
            .orderZip(orderZip)
            .orderBas(orderBas)
            .orderDet(orderDet)
            .cardNum(cardNum)
            .cardVal(cardVal)
            .cardPeriod(cardPeriod)
            .build();
    }

}
