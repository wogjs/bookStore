package com.project.bookstore.domain.users;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @Column(name = "Users_id")
    private String id;

    @Column(length = 500, nullable = false)
    private String pw;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_Name;
    private String mem = "B";
    private int total_Sum = 0;
//    private String non_user;
//    private String sns_login;

    @Builder
    public Users(String id, String pw, String name, String sex, int num, String mail, String nic_Name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_Name = nic_Name;
    }

}
