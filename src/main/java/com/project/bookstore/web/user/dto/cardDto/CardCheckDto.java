package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;
import lombok.Getter;

@Getter
public class CardCheckDto {
    private String users_id;
    private String card_Num;

    public CardCheckDto(Cards entity) {
        this.users_id = entity.getUsers_ID();
        this.card_Num = entity.getCard_Num();
    }
}
