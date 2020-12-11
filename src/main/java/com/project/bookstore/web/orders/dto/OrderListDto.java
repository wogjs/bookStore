package com.project.bookstore.web.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDto {
    private Long order_code;
    private String book_isbn;
    private Long order_amount;
    private Long order_sum;
    
    // private LocalDateTime createdDate;
    // private String name;
    
}
