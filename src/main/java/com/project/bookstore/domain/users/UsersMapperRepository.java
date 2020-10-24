package com.project.bookstore.domain.users;

import com.project.bookstore.web.user.dto.userDto.UserInfoDto;
import com.project.bookstore.web.user.dto.userDto.UserSignInDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperRepository {
    public UserInfoDto signIn(UserSignInDto userSignInDto);
}
