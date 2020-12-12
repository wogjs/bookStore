package com.project.bookstore.web.book.dto;

import com.project.bookstore.domain.books.Books;
import lombok.*;

@Getter
@NoArgsConstructor
public class BookInsertDto {

    private String isbn;
    private String bookName;
    private String bookAut;
    private String bookTrans;
    private String bookDate;
    private String bookHouse;
    private String bookCov;
    private int bookPri;
    private String bookGen;
    private String bookDet;
    private Long bookSto;

    @Builder
    private BookInsertDto(String isbn, String bookName, String bookAut, String bookTrans, String bookDate,
            String bookHouse, String bookCov, int bookPri, String bookGen, String bookDet, Long bookSto) {
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
        this.bookSto = bookSto;
    }

    public Books toEntity() {
        return Books.builder().isbn(isbn).bookName(bookName).bookAut(bookAut).bookTrans(bookTrans).bookDate(bookDate)
                .bookHouse(bookHouse).bookCov(bookCov).bookPri(bookPri).bookGen(bookGen).bookDet(bookDet)
                .bookSto(bookSto).build();
    }
}
