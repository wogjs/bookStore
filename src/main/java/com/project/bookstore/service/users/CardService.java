package com.project.bookstore.service.users;

import com.project.bookstore.domain.cards.CardsRepository;
import com.project.bookstore.web.user.dto.cardDto.CardCheckDto;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import com.project.bookstore.web.user.dto.cardDto.CardListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardsRepository cardsRepository;

    // 카드 등록
    @Transactional
    public String cardSave(CardInsertDto insertDto) {
        return cardsRepository.save(insertDto.toEntity()).getCardNum();
    }

    // 카드 중복 검사
    @Transactional
    public List<CardCheckDto> findByCard(String id, String cardNum) {
        return cardsRepository.findByCard(id, cardNum).stream()
                .map(CardCheckDto::new)
                .collect(Collectors.toList());
    }

    // 카드 조회
    @Transactional
    public List<CardListDto> findCard(String usersID){
        return cardsRepository.findAll(usersID).stream()
                .map(CardListDto::new)
                .collect(Collectors.toList());
    }
}
