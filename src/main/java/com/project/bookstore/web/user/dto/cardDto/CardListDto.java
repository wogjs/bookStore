package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;
import lombok.Getter;

@Getter
public class CardListDto {
    private String cardNum;
    private String cardPeriod;
    private String cardVal;

    public CardListDto(Cards entity) {
        this.cardNum = entity.getCardNum();
        this.cardPeriod = entity.getCardPeriod();
        this.cardVal = entity.getCardVal();
    }
}
