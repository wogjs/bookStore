package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.users.Users;
import lombok.Getter;

@Getter
public class UserCheckDto {
    private String id;
    private String pw;


    public UserCheckDto(Users entity) {
        this.id = entity.getId();
        this.pw = entity.getPw();
    }
}
