package com.project.bookstore.domain.users;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    private String id;

    @Column(length = 500, nullable = false)
    private String pw;
    private String name;
    private String sex;
    private String num;
    private String mail;
    private String nicName;
    private String mem = "B";
    private int totalSum = 0;
    private String creates;
//    private String nonuser;
//    private String snslogin;

    @Builder
    public Users(String id, String pw, String name, String sex, String num, String mail, String nicName, String creates) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
        this.creates = creates;
    }

    public void update(String pw, String name, String num, String mail, String nicName) {
        this.pw = pw;
        this.name = name;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
    }
}
