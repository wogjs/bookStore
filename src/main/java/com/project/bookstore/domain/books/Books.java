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
    private String book_Trans;
    private Date book_Date;
    private String book_Cov;
    private int book_Pri;
    private String book_Gen;
    private String book_Det;

    @Builder
    public Books(String isbn, String bookName, String bookAut, String book_Trans, Date book_Date, String book_Cov, int book_Pri, String book_Gen, String book_Det) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAut = bookAut;
        this.book_Trans = book_Trans;
        this.book_Date = book_Date;
        this.book_Cov = book_Cov;
        this.book_Pri = book_Pri;
        this.book_Gen = book_Gen;
        this.book_Det = book_Det;
    }
}
