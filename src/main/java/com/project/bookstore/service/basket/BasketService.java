package com.project.bookstore.service.basket;

import com.project.bookstore.domain.basket.BasketRepository;
import com.project.bookstore.domain.basketInfo.BasketInfoRepository;
import com.project.bookstore.domain.basketInfo.MultiId;
import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.basket.dto.BasketInsertDto;
import com.project.bookstore.web.basket.dto.InfoInsertDto;

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
        return usersRepository.findById(userInfo.getUserId()).get();
    }

    // 장바구니 유뮤 확인
    @Transactional
    public Boolean basketFind(UserInfo userInfo) {
        System.out.println("fjdsaklfjasdk;lfjasdkl;fjasl;dkfj;aslkdfj");
        if (basketRepository.findByUsers_Id(userInfo.getUserId()) == null) {
            System.out.println("여기왔는가222222222222");
            return false;
        } else {
            System.out.println("여기왔는가33333333333333333333");
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
}
