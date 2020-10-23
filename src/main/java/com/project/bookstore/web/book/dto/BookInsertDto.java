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
    private String book_Trans;
    private Date book_Date;
    private String book_Cov;
    private int book_Pri;
    private String book_Gen;
    private String book_Det;

    @Builder
    private BookInsertDto(String isbn, String bookName, String bookAut, String book_Trans, Date book_Date, String book_Cov, int book_Pri, String book_Gen, String book_Det) {
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

    public Books toEntity() {
        return Books.builder()
                .isbn(isbn)
                .bookName(bookName)
                .bookAut(bookAut)
                .book_Trans(book_Trans)
                .book_Date(book_Date)
                .book_Cov(book_Cov)
                .book_Pri(book_Pri)
                .book_Gen(book_Gen)
                .book_Det(book_Det)
                .build();
    }
}
