package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.user.dto.userDto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "회원", description = "회원 관리", tags = { "회원" })
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;
    private final UserInfo userInfo;

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/userJoin")
    public ResponseEntity<?> save (@RequestBody UserSignUpDto requestDto) {
        ApiResponse result = null;
        UserCheckDto idCheck = new UserCheckDto(usersService.findById(requestDto.getId()));

        if (idCheck.getId() == null) {
            try{
                if (requestDto.getId() != "") {
                    result = new ApiResponse(true, "성공", usersService.save(requestDto));
                    return ResponseEntity.ok().body(result);
                } else {
                    result = new ApiResponse(false, "실패", null);
                    return ResponseEntity.badRequest().body(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new ApiResponse(false, e.getMessage(), null);
                return ResponseEntity.badRequest().body(result);
            }
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "로그인")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody UserSignInDto userSignInDto){
        ApiResponse result = null;
        try{
            Boolean login = usersService.signIn(userSignInDto);
            if(login == true) {
                result = new ApiResponse(true, "성공", login);
                userInfo.setUserId(userSignInDto.getId());
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "아이디나 비밀번호가 없습니다.", login);
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "정보 수정")
    @PutMapping("/mypage/update/{id}")
    public ResponseEntity<?> mypageUpdate(@PathVariable("id") String id, @RequestBody UserUpdateDto updateDto) {
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "성공", usersService.update(id, updateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ApiResponse result = null;
        userInfo.setUserId(null);
        result = new ApiResponse(true, "로그아웃", userInfo.getUserId());
        return ResponseEntity.ok().body(result);
    }
}