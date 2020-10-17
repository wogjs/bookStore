package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;
import lombok.Getter;

import java.util.Date;

@Getter
public class CardListDto {
    private String card_Num;
    private Date card_Period;
    private String card_Val;

    public CardListDto(Cards entity) {
        this.card_Num = entity.getCard_Num();
        this.card_Period = entity.getCard_Period();
        this.card_Val = entity.getCard_Val();
    }
}
