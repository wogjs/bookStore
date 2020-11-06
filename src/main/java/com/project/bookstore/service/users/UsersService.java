
package com.project.bookstore.service.users;

import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersMapperRepository;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.user.dto.userDto.UserInfoDto;
import com.project.bookstore.web.user.dto.userDto.UserSignInDto;
import com.project.bookstore.web.user.dto.userDto.UserSignUpDto;
import com.project.bookstore.web.user.dto.userDto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapperRepository usersMapperRepository;

    // 회원가입
    @Transactional
    public String save(UserSignUpDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

    // 중복 검사
    @Transactional
    public Users findById(String id) {
        return usersRepository.findById(id).orElseGet(Users::new);
    }

    // 로그인
    @Transactional
    public Boolean signIn(UserSignInDto signInDto) {
        return usersRepository.getOne(signInDto.getId()).getPw().equals(signInDto.getPw());
    }

    // 개인 정보 변경
    @Transactional
    public Users update(String id, UserUpdateDto updateDto) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("에러"));

        users.update(updateDto.getPw(), updateDto.getName(), updateDto.getNum(), updateDto.getMail(), updateDto.getNicName());

        return users;
    }

    @Transactional
    public Users findUsers(UserInfo userInfo){
        return usersRepository.findById(userInfo.getUserId()).get();
    }
}