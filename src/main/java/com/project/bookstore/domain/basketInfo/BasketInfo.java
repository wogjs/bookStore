package com.project.bookstore.domain.basketInfo;

import com.project.bookstore.domain.basket.Basket;
import com.project.bookstore.domain.books.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class BasketInfo implements Serializable {
    @EmbeddedId
    private MultiId multiId;

    private Long basAmount;

    @MapsId("basCode")
    @ManyToOne
    @JoinColumn(name = "bas_code")
    private Basket basket;

    @MapsId("isbn")
    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Books books;

    @Builder
    public BasketInfo(MultiId multiId, Long basAmount) {
        this.multiId = multiId;
        this.basAmount = basAmount;
    }
}
