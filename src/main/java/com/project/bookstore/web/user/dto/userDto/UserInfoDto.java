package com.project.bookstore.web.user.dto.userDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private String num;
    private String mail;
    private String nicName;
    private int totalSum;
}
