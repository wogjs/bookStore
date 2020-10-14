package com.project.bookstore.domain.users;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Users")
public class Users {

    @Id
    private String userID;

    @Column(length = 500, nullable = false)
    private String userPW;
    private String name;
    private String sex;
    private int num;
    private String mail;
    private String nic_name;
    private String mem = "B";
    private int total_sum = 0;
    private Role role;
//    private String non_user;
//    private String sns_login;

    @Builder
    public Users(String userID, String userPW, String name, String sex, int num, String mail, String nic_name, Role role) {
        this.userID = userID;
        this.userPW = userPW;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nic_name = nic_name;
        this.role = role;
    }

}
