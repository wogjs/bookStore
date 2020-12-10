package com.project.bookstore.domain.basketInfo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
@SuppressWarnings("serial")
public class MultiId implements Serializable {

    private Long bas_code;

    private String book_isbn;
}
