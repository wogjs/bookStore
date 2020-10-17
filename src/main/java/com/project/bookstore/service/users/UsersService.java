
package com.project.bookstore.service.users;

import com.project.bookstore.domain.addr.AddrRepository;
import com.project.bookstore.domain.cards.CardsRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersMapperRepository;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import com.project.bookstore.web.user.dto.addrDto.AddrListDto;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import com.project.bookstore.web.user.dto.cardDto.CardListDto;
import com.project.bookstore.web.user.dto.userDto.UserInfoDto;
import com.project.bookstore.web.user.dto.userDto.UserSignInDto;
import com.project.bookstore.web.user.dto.userDto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapperRepository usersMapperRepository;

    private final CardsRepository cardsRepository;

    private final AddrRepository addrRepository;

    // 회원가입
    @Transactional
    public String save(UserSignUpDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Users findById(String id) {
        Users entity = usersRepository.findById(id).orElseGet(Users::new);

        return entity;
    }

    //로그인
    public UserInfoDto signIn(UserSignInDto signInDto) {
        return usersMapperRepository.signIn(signInDto);
    }

    //카드 등록
    @Transactional
    public String cardSave(CardInsertDto insertDto) {
        return cardsRepository.save(insertDto.toEntity()).getCard_Num();
    }

    //카드 조회
    @Transactional
    public List<CardListDto> findCard(String users_ID){
        return cardsRepository.findAll(users_ID).stream()
                .map(CardListDto::new)
                .collect(Collectors.toList());
    }

    //주소 등록
    @Transactional
    public Long addrSave(AddrInsertDto insertDto) {
        return addrRepository.save(insertDto.toEntity()).getAddr_Zip();
    }

    @Transactional
    public List<AddrListDto> findAddr(String users_ID) {
        return addrRepository.findAll(users_ID).stream()
                .map(AddrListDto::new)
                .collect(Collectors.toList());
    }

}