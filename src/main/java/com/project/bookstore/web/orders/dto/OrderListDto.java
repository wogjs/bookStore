package com.project.bookstore.web.orders.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDto {
    private Long order_code;
    private String book_name;
    private String order_amount;
    private Long order_sum;
    private LocalDateTime created_date;
    // private String name;
    
}
