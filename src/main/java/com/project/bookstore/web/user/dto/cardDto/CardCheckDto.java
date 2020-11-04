package com.project.bookstore.web.user.dto.cardDto;

import com.project.bookstore.domain.cards.Cards;
import com.project.bookstore.domain.users.Users;
import lombok.Getter;

@Getter
public class CardCheckDto {
    private Users users;
    private String cardNum;

    public CardCheckDto(Cards entity) {
        this.users = entity.getUsers();
        this.cardNum = entity.getCardNum();
    }
}
