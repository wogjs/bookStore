package com.project.bookstore.service.users;

import com.project.bookstore.domain.cards.Cards;
import com.project.bookstore.domain.cards.CardsRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.user.dto.cardDto.CardCheckDto;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import com.project.bookstore.web.user.dto.cardDto.CardListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardsRepository cardsRepository;
    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public Users findUsers(UserInfo userInfo) {
        return usersRepository.findById(userInfo.getUserId()).get();
    }

    // 카드 등록
    @Transactional
    public String cardSave(CardInsertDto insertDto) {
        return cardsRepository.save(insertDto.toEntity()).getCardNum();
    }

//    // 카드 중복 검사
//    @Transactional
//    public List<CardCheckDto> findByCard(UserInfo userInfo, String cardNum) {
//        return cardsRepository.findByCard(userInfo, cardNum).stream()
//                .map(CardCheckDto::new)
//                .collect(Collectors.toList());
//    }

    // 카드 조회
    @Transactional
    public List<CardListDto> findCard(UserInfo userInfo){
        return cardsRepository.findAllByUsers_Id(userInfo.getUserId()).stream()
                .map(CardListDto::new)
                .collect(Collectors.toList());
    }

    // 카드삭제
    @Transactional
    public void cardDelete(String cardNum) {
        Cards cards = cardsRepository.findById(cardNum)
                .orElseThrow(() -> new IllegalArgumentException("삭제에 실패했습니다."));

        cardsRepository.delete(cards);
    }
}
