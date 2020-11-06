package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;

import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CardInsertDto {
    private String cardNum;
    private Users users;
    private String cardPeriod;
    private Long cardCVC;
    private Long cardPW;
    private String cardVal;

    @Builder
    private CardInsertDto(String cardNum, Users users, String cardPeriod, Long cardCVC, Long cardPW, String cardVal) {
        this.cardNum = cardNum;
        this.users = users;
        this.cardPeriod = cardPeriod;
        this.cardCVC = cardCVC;
        this.cardPW = cardPW;
        this.cardVal = cardVal;
    }

    public Cards toEntity() {
        return Cards.builder()
                .cardNum(cardNum)
                .users(users)
                .cardPeriod(cardPeriod)
                .cardCVC(cardCVC)
                .cardPW(cardPW)
                .cardVal(cardVal)
                .build();
    }
}
