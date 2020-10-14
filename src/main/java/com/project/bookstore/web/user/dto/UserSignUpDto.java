package com.project.bookstore.web.user.dto;

//import com.project.bookstore.domain.users.UserSignUP;
import com.project.bookstore.domain.users.Users;
import lombok.*;

@Getter
@NoArgsConstructor
public class UserSignUpDto {
    private String userID;
    private String userPW;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;

    @Builder
    private UserSignUpDto(String userID, String userPW, String name, String sex, int num, String mail, String nic_name) {
        this.userID = userID;
        this.userPW = userPW;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_name = nic_name;
    }

    public Users toEntity() {
        return Users.builder()
                .userID(userID)
                .userPW(userPW)
                .name(name)
                .sex(sex)
                .num(num)
                .mail(mail)
                .nic_name(nic_name)
                .build();
    }
}
