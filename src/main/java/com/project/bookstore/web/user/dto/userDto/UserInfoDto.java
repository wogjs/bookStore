package com.project.bookstore.web.user.dto.userDto;

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
    private String num;
    private String mail;
    private String nic_Name;
    private int total_Sum;
}
