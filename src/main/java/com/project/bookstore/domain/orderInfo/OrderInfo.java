package com.project.bookstore.domain.orderInfo;

import com.project.bookstore.domain.books.Books;
import com.project.bookstore.domain.orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class OrderInfo implements Serializable {
    @EmbeddedId
    private MultiId multiId;

    private Long orderAmount;

    @MapsId("orderCode")
    @ManyToOne
    @JoinColumn(name = "order_code")
    private Orders orders;

    @MapsId("isbn")
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Books books;

    @Builder
    private OrderInfo (MultiId multiId, Long orderAmount, Orders orders, Books books) {
        this.multiId = multiId;
        this.orderAmount = orderAmount;
        this.orders = orders;
        this.books = books;
    }
}
