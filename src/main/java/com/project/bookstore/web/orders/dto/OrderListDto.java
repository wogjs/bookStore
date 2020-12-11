package com.project.bookstore.web.orders.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class OrderListDto {
    private Long orderCode;
    private String isbn;
    private Long orderAmount;
    private Long orderSum;
    
    // private LocalDateTime createdDate;
    // private String name;
    
}
