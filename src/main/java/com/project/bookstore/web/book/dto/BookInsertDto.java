package com.project.bookstore.web.book.dto;

import com.project.bookstore.domain.books.Books;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
public class BookInsertDto {

    private String isbn;
    private String bookName;
    private String bookAut;
    private String bookTrans;
    private Date bookDate;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;

    @Builder
    private BookInsertDto(String isbn, String bookName, String bookAut, String bookTrans, Date bookDate, String bookCov, int bookPri, String bookGen, String bookDet) {
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

    public Books toEntity() {
        return Books.builder()
                .isbn(isbn)
                .bookName(bookName)
                .bookAut(bookAut)
                .bookTrans(bookTrans)
                .bookDate(bookDate)
                .bookCov(bookCov)
                .bookPri(bookPri)
                .bookGen(bookGen)
                .bookDet(bookDet)
                .build();
    }
}
