package com.project.bookstore.domain.orderInfo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
@SuppressWarnings("serial")
public class MultiId implements Serializable {

    private Long orderCode;

    private String isbn;
}
