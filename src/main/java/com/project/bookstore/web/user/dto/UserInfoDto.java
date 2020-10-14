package com.project.bookstore.web.user.dto;

import com.project.bookstore.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
    private String userID;
    private String userPW;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;
    private int total_sum;
}
