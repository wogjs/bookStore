package com.project.bookstore.domain.orders;

import com.project.bookstore.domain.BaseTimeEntity;
import com.project.bookstore.domain.orderInfo.OrderInfo;
import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Orders extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long orderCode;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private Long orderSum;
    private Long orderZip;
    private String orderBas;
    private String orderDet;

    @OneToMany(mappedBy = "orders")
    private List<OrderInfo> orderInfo;

    @Builder
    public Orders(Users users, Long orderSum, Long orderZip, String orderBas, String orderDet,
            List<OrderInfo> orderInfo) {
        this.users = users;
        this.orderSum = orderSum;
        this.orderZip = orderZip;
        this.orderBas = orderBas;
        this.orderDet = orderDet;
        this.orderInfo = orderInfo;
    }
}
