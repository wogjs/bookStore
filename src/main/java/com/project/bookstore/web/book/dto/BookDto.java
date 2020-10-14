package com.project.bookstore.web.book.dto;

import com.project.bookstore.domain.book.Books;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class BookDto {

    private String ISBN;
    private String book_name;
    private String book_aut;
    private String book_trans;
    private Date book_date;
    private String book_cov;
    private int book_pri;
    private String book_gen;
    private String book_det;

    @Builder
    private BookDto(String ISBN, String book_name, String book_aut, String book_trans, Date book_date, String book_cov, int book_pri, String book_gen, String book_det) {
        this.ISBN = ISBN;
        this.book_name = book_name;
        this.book_aut = book_aut;
        this.book_trans = book_trans;
        this.book_date = book_date;
        this.book_cov = book_cov;
        this.book_pri = book_pri;
        this.book_gen = book_gen;
        this.book_det = book_det;
    }

    public Books toEntity() {
        return Books.builder()
                .ISBN(ISBN)
                .book_name(book_name)
                .book_aut(book_aut)
                .book_trans(book_trans)
                .book_date(book_date)
                .book_cov(book_cov)
                .book_pri(book_pri)
                .book_gen(book_gen)
                .book_det(book_det)
                .build();
    }
}
