package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;
import lombok.Getter;

@Getter
public class CardCheckDto {
    private String usersid;
    private String cardNum;

    public CardCheckDto(Cards entity) {
        this.usersid = entity.getUsersID();
        this.cardNum = entity.getCardNum();
    }
}
