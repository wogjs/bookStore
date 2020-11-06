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
    private String cardNum;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private String cardPeriod;
    private Long cardCVC;
    private Long cardPW;
    private String cardVal;

    @Builder
    public Cards (String cardNum, Users users, String cardPeriod, Long cardCVC, Long cardPW, String cardVal) {
        this.cardNum = cardNum;
        this.users = users;
        this.cardPeriod = cardPeriod;
        this.cardCVC = cardCVC;
        this.cardPW = cardPW;
        this.cardVal = cardVal;
    }


}
