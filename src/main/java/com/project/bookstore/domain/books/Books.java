package com.project.bookstore.domain.books;

import com.project.bookstore.domain.basketInfo.BasketInfo;
import com.project.bookstore.domain.orderInfo.OrderInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {

    @Id
    private String isbn;

    @Column
    private String bookName;
    private String bookAut;
    private String bookTrans;
    private String bookDate;
    private String bookHouse;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;
    private int bookSto;

    @OneToMany(mappedBy = "books")
    private List<OrderInfo> orderInfo;

    @OneToMany(mappedBy = "books")
    private List<BasketInfo> basketInfo;

    @Builder
    public Books(String isbn, String bookName, String bookAut, String bookTrans, String bookDate, String bookHouse,
            String bookCov, int bookPri, String bookGen, String bookDet, int bookSto, List<OrderInfo> orderInfo,
            List<BasketInfo> basketInfo) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookTrans = bookTrans;
        this.bookDate = bookDate;
        this.bookHouse = bookHouse;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
        this.orderInfo = orderInfo;
        this.basketInfo = basketInfo;
        this.bookSto = bookSto;
    }

    public void update(String bookTrans, String bookCov, int bookPri, String bookDet, int bookSto) {
        this.bookTrans = bookTrans;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookDet = bookDet;
        this.bookSto = bookSto;
    }
}
