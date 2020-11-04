package com.project.bookstore.domain.books;

import com.project.bookstore.domain.basketInfo.BasketInfo;
import com.project.bookstore.domain.orderInfo.OrderInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
    private Date bookDate;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;

    @OneToMany(mappedBy = "books")
    private List<OrderInfo> orderInfo;

    @OneToMany(mappedBy = "books")
    private List<BasketInfo> basketInfo;

    @Builder
    public Books(String isbn, String bookName, String bookAut, String bookTrans, Date bookDate, String bookCov, int bookPri,
                 String bookGen, String bookDet, List<OrderInfo> orderInfo, List<BasketInfo> basketInfo) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookTrans = bookTrans;
        this.bookDate = bookDate;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
        this.orderInfo = orderInfo;
        this.basketInfo = basketInfo;
    }

    public void update(String bookTrans, String bookCov, int bookPri, String bookDet) {
        this.bookTrans = bookTrans;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookDet = bookDet;
    }
}
