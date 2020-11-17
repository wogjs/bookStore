package com.project.bookstore.web.book.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateDto {
    private String bookTrans;
    private String bookCov;
    private int bookPri;
    private String bookDet;
    private int bookSto;

    @Builder
    public BookUpdateDto(String bookTrans, String bookCov, int bookPri, String bookDet, int bookSto){
        this.bookTrans = bookTrans;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookDet = bookDet;
        this.bookSto = bookSto;
    }
}
