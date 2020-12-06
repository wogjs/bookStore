package com.project.bookstore.web.book.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateDto {
    private String bookAut;
    private String bookTrans;
    private String bookCov;
    private int bookPri;
    private String bookDet;
    private Long bookSto;

    @Builder
    public BookUpdateDto(String bookAut, String bookTrans, String bookCov, int bookPri, String bookDet, Long bookSto) {
        this.bookAut = bookAut;
        this.bookTrans = bookTrans;
        this.bookCov = bookCov;
        this.bookPri = bookPri;
        this.bookDet = bookDet;
        this.bookSto = bookSto;
    }
}
