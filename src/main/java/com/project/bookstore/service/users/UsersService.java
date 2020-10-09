package com.project.bookstore.service.users;

import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.web.user.dto.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public String save(UserSignUpDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getId();
    }

}
