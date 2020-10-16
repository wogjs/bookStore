package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.users.Users;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_Name;
    private int total_Sum;
}
