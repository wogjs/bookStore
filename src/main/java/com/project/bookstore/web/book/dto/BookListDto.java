package com.project.bookstore.web.book.dto;

import com.project.bookstore.domain.books.Books;
import lombok.Getter;

import java.util.Date;

@Getter
public class BookListDto {
    private String isbn;
    private String bookName;
    private String bookAut;
    private String book_Trans;
    private Date book_Date;
    private String book_Cov;
    private int book_Pri;
    private String book_Gen;
    private String book_Det;

    public BookListDto(Books entity) {
        this.isbn = entity.getIsbn();
        this.bookName = entity.getBookName();
        this.bookAut = entity.getBookAut();
        this.book_Trans = entity.getBook_Trans();
        this.book_Date = entity.getBook_Date();
        this.book_Cov = entity.getBook_Cov();
        this.book_Pri = entity.getBook_Pri();
        this.book_Gen = entity.getBook_Gen();
        this.book_Det = entity.getBook_Det();
    }
}
