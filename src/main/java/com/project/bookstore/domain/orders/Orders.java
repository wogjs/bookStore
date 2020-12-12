package com.project.bookstore.domain.orders;

import com.project.bookstore.domain.BaseTimeEntity;
import com.project.bookstore.domain.orderInfo.OrderInfo;
import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    private String cardNum;
    private String cardVal;
    private String cardPeriod;

    @OneToMany(mappedBy = "orders")
    private List<OrderInfo> orderInfo;

    @Builder
    public Orders(Users users, Long orderSum, Long orderZip, String orderBas, String orderDet,
            String cardNum, String cardVal, String cardPeriod, List<OrderInfo> orderInfo) {
        this.users = users;
        this.orderSum = orderSum;
        this.orderZip = orderZip;
        this.orderBas = orderBas;
        this.orderDet = orderDet;
        this.cardNum = cardNum;
        this.cardVal = cardVal;
        this.cardPeriod = cardPeriod;
        this.orderInfo = orderInfo;
    }
}
