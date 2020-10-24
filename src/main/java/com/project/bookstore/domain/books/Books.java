package com.project.bookstore.domain.books;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Builder
    public Books(String isbn, String bookName, String bookAut, String bookTrans, Date bookDate, String bookCov, int bookPri, String bookGen, String bookDet) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.bookTrans = bookTrans;
        this.bookDate = bookDate;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookGen = bookGen;
        this.bookDet = bookDet;
    }
}
