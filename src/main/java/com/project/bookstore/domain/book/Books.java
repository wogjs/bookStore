package com.project.bookstore.domain.book;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Books {

    @Id
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
    public Books(String ISBN, String book_name, String book_aut, String book_trans, Date book_date, String book_cov, int book_pri, String book_gen, String book_det) {
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
}
