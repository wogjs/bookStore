package com.project.bookstore.domain.users;

import com.project.bookstore.web.user.dto.UserInfoDto;
import com.project.bookstore.web.user.dto.UserSignInDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapperRepository {
    public UserInfoDto signIn(UserSignInDto userSignInDto);
}
