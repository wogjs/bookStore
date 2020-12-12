package com.project.bookstore.domain.users;

import com.project.bookstore.domain.BaseTimeEntity;
import com.project.bookstore.domain.addr.Addr;
import com.project.bookstore.domain.basket.Basket;
import com.project.bookstore.domain.cards.Cards;
import com.project.bookstore.domain.orders.Orders;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

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

    // private String nonuser;
    // private String snslogin;

    @OneToMany(mappedBy = "users")
    private List<Cards> cards;

    @OneToMany(mappedBy = "users")
    private List<Addr> addr;

    @OneToMany(mappedBy = "users")
    private List<Orders> orders;

    @OneToMany(mappedBy = "users")
    private List<Basket> basket;

    @Builder
    public Users(String id, String pw, String name, String sex, String num, String mail, String nicName,
            List<Cards> cards, List<Addr> addr, List<Basket> basket) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
        this.cards = cards;
        this.addr = addr;
        this.basket = basket;
    }

    public void update(String pw, String name, String num, String mail, String nicName) {
        this.pw = pw;
        this.name = name;
        this.num = num;
        this.mail = mail;
        this.nicName = nicName;
    }
}
