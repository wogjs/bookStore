
package com.project.bookstore.service.users;

import com.project.bookstore.domain.addr.AddrRepository;
import com.project.bookstore.domain.cards.CardsRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersMapperRepository;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import com.project.bookstore.web.user.dto.addrDto.AddrListDto;
import com.project.bookstore.web.user.dto.cardDto.CardCheckDto;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import com.project.bookstore.web.user.dto.cardDto.CardListDto;
import com.project.bookstore.web.user.dto.userDto.UserInfoDto;
import com.project.bookstore.web.user.dto.userDto.UserSignInDto;
import com.project.bookstore.web.user.dto.userDto.UserSignUpDto;
import com.project.bookstore.web.user.dto.userDto.UserUpdateDto;
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

    // 중복 검사
    @Transactional
    public Users findById(String id) {
        Users entity = usersRepository.findById(id).orElseGet(Users::new);

        return entity;
    }

    // 로그인
    public UserInfoDto signIn(UserSignInDto signInDto) {
        return usersMapperRepository.signIn(signInDto);
    }

    // 카드 등록
    @Transactional
    public String cardSave(CardInsertDto insertDto) {
        return cardsRepository.save(insertDto.toEntity()).getCard_Num();
    }

    // 카드 중복 검사
    @Transactional
    public List<CardCheckDto> findByCard(String id, String card_Num) {
        return cardsRepository.findByCard(id, card_Num).stream()
                .map(CardCheckDto::new)
                .collect(Collectors.toList());
    }

    // 카드 조회
    @Transactional
    public List<CardListDto> findCard(String users_ID){
        return cardsRepository.findAll(users_ID).stream()
                .map(CardListDto::new)
                .collect(Collectors.toList());
    }

    // 주소 등록
    @Transactional
    public Long addrSave(AddrInsertDto insertDto) {
        return addrRepository.save(insertDto.toEntity()).getAddr_Zip();
    }

    // 주소 조회
    @Transactional
    public List<AddrListDto> findAddr(String users_ID) {
        return addrRepository.findAll(users_ID).stream()
                .map(AddrListDto::new)
                .collect(Collectors.toList());
    }

    // 기본 배송지 변경
    @Transactional
    public void addrUpdateYN(String users_id) {
        addrRepository.updateAddrYN(users_id);
    }

    // 개인 정보 변경
    @Transactional
    public Users update(String id, UserUpdateDto updateDto) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("에러"));

        users.update(updateDto.getPw(), updateDto.getName(), updateDto.getNum(), updateDto.getMail(), updateDto.getNic_Name());

        return users;
    }
}