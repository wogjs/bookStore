package com.project.bookstore.service.basket;

import java.util.List;
import java.util.stream.Collectors;

import com.project.bookstore.domain.basket.BasketRepository;
import com.project.bookstore.domain.basketInfo.BasketInfoRepository;
import com.project.bookstore.domain.basketInfo.MultiId;
import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.basket.dto.BasketInsertDto;
import com.project.bookstore.web.basket.dto.InfoInsertDto;
import com.project.bookstore.web.basket.dto.InfoListDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketInfoRepository infoRepository;
    private final BooksRepository booksRepository;
    private final UsersRepository usersRepository;
    private final UserInfo userInfo;

    @Transactional(readOnly = true)
    public Users findUsers(UserInfo userInfo) {
        if(userInfo.getUserId() == null) {
            return null;
        } else {
            return usersRepository.findById(userInfo.getUserId()).get();
        }
    }

    // 장바구니 유뮤 확인
    @Transactional
    public Boolean basketFind(UserInfo userInfo) {
        if (basketRepository.findByUsers_Id(userInfo.getUserId()) == null) {
            return false;
        } else {
            return true;
        }
    }

    // 장바구니 생성
    @Transactional
    public Long basInsert(BasketInsertDto insertDto) {
        return basketRepository.save(insertDto.toEntity()).getBasCode();
    }

    // 책 추가
    @Transactional
    public Long infoInsert(String isbn, InfoInsertDto insertDto) {
        MultiId multiId = new MultiId();
        multiId.setBook_isbn(isbn);
        multiId.setBas_code(basketRepository.findByUsers_Id(userInfo.getUserId()).getBasCode());
        insertDto.setMultiId(multiId);
        insertDto.setBooks(booksRepository.findById(isbn).get());
        insertDto.setBasket(basketRepository.findByUsers_Id(userInfo.getUserId()));
        System.out.println(insertDto.getMultiId());
        return infoRepository.save(insertDto.toEntity()).getMultiId().getBas_code();
    }

    // 장바구니 리스트 출력
    @Transactional
    public List<InfoListDto> infoList() {
        System.out.println(userInfo.getUserId());
        if(userInfo.getUserId() == null) {
            return null;
        } else {
            return infoRepository.findByBasket(basketRepository.findByUsers_Id(userInfo.getUserId())).stream()
                    .map(InfoListDto::new)
                    .collect(Collectors.toList());
        }
    }
}
