package com.project.bookstore.web.user.dto;

//import com.project.bookstore.domain.users.UserSignUP;
import com.project.bookstore.domain.users.Users;
import lombok.*;

@Getter
@NoArgsConstructor
public class UserSignUpDto {
    private String id;
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_Name;

    @Builder
    private UserSignUpDto(String id, String pw, String name, String sex, int num, String mail, String nic_Name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_Name = nic_Name;
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
                .build();
    }
}
