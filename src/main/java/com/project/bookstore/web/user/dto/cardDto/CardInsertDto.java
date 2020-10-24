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
    private String card_Num;
    private String users_ID;
    private Date card_Period;
    private Long card_CVC;
    private Long card_PW;
    private String card_Val;

    @Builder
    private CardInsertDto(String card_Num, String users_ID, Date card_Period, Long card_CVC, Long card_PW, String card_Val) {
        this.card_Num = card_Num;
        this.users_ID = users_ID;
        this.card_Period = card_Period;
        this.card_CVC = card_CVC;
        this.card_PW = card_PW;
        this.card_Val = card_Val;
    }

    public Cards toEntity() {
        return Cards.builder()
                .card_Num(card_Num)
                .users_ID(users_ID)
                .card_Period(card_Period)
                .card_CVC(card_CVC)
                .card_PW(card_PW)
                .card_Val(card_Val)
                .build();
    }
}
