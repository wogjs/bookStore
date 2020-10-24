package com.project.bookstore.domain.cards;

import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Cards {
    @Id
    private String card_Num;

    @Column(name = "Users_id")
    private String users_ID;

    private Date card_Period;
    private Long card_CVC;
    private Long card_PW;
    private String card_Val;

    @Builder
    public Cards (String card_Num, String users_ID, Date card_Period, Long card_CVC, Long card_PW, String card_Val) {
        this.card_Num = card_Num;
        this.users_ID = users_ID;
        this.card_Period = card_Period;
        this.card_CVC = card_CVC;
        this.card_PW = card_PW;
        this.card_Val = card_Val;
    }


}
