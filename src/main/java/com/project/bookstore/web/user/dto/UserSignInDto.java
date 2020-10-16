package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignInDto {
    private String id;
    private String pw;
}
