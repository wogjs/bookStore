package com.project.bookstore.domain.basket;

import com.project.bookstore.domain.BaseTimeEntity;
import com.project.bookstore.domain.basketInfo.BasketInfo;
import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Basket extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long basCode;

    private String modifytime;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy = "basket")
    private List<BasketInfo> basketInfo;

    @Builder
    public Basket(Users users) {
        this.users = users;
    }
}
