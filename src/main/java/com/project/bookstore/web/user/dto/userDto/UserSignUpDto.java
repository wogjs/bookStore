package com.project.bookstore.web.user.dto.userDto;

//import com.project.bookstore.domain.users.UserSignUP;
import com.project.bookstore.domain.users.Users;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserSignUpDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private String num;
    private String mail;
    private String nic_Name;
    private String creates;

    @Builder
    private UserSignUpDto(String id, String pw, String name, String sex, String num, String mail, String nic_Name, String creates) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_Name = nic_Name;
        this.creates = creates;
    }

    public Users toEntity() {
        return Users.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .sex(sex)
                .num(num)
                .mail(mail)
                .nic_Name(nic_Name)
                .creates(creates)
                .build();
    }
}
