package com.project.bookstore.web.user.dto.userDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String pw;
    private String name;
    private String num;
    private String mail;
    private String nic_Name;

    @Builder
    public UserUpdateDto(String pw, String name, String num, String mail, String nic_Name) {
        this.pw = pw;
        this.name = name;
        this.num = num;
        this.mail = mail;
        this.nic_Name = nic_Name;
    }

}
