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

    @Column(name = "Users_id")
    private String usersID;

    private Date cardPeriod;
    private Long cardCVC;
    private Long cardPW;
    private String cardVal;

    @Builder
    public Cards (String cardNum, String usersID, Date cardPeriod, Long cardCVC, Long cardPW, String cardVal) {
        this.cardNum = cardNum;
        this.usersID = usersID;
        this.cardPeriod = cardPeriod;
        this.cardCVC = cardCVC;
        this.cardPW = cardPW;
        this.cardVal = cardVal;
    }


}
