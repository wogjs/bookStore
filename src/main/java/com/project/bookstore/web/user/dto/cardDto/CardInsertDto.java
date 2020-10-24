package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;

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
    private String usersID;
    private Date cardPeriod;
    private Long cardCVC;
    private Long cardPW;
    private String cardVal;

    @Builder
    private CardInsertDto(String cardNum, String usersID, Date cardPeriod, Long cardCVC, Long cardPW, String cardVal) {
        this.cardNum = cardNum;
        this.usersID = usersID;
        this.cardPeriod = cardPeriod;
        this.cardCVC = cardCVC;
        this.cardPW = cardPW;
        this.cardVal = cardVal;
    }

    public Cards toEntity() {
        return Cards.builder()
                .cardNum(cardNum)
                .usersID(usersID)
                .cardPeriod(cardPeriod)
                .cardCVC(cardCVC)
                .cardPW(cardPW)
                .cardVal(cardVal)
                .build();
    }
}
