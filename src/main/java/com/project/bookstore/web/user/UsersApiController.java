
package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.user.dto.UserInfoDto;
import com.project.bookstore.web.user.dto.UserSignInDto;
import com.project.bookstore.web.user.dto.UserSignUpDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "회원", description = "로그인 관리", tags = { "로그인" })
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/userJoin")
    public String save (@RequestBody UserSignUpDto requestDto) {

        return usersService.save(requestDto);
    }

    @ApiOperation(value = "로그인")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "로그인", required = true, dataType = "string", paramType = "query", defaultValue = ""), })
    @PostMapping("/login")
    public ResponseEntity<?> signin(@RequestBody UserSignInDto userSignInDto){
        ApiResponse result = null;
        try{
            System.out.println(userSignInDto);
            UserInfoDto userInfoDto = usersService.signIn(userSignInDto);
            if(userInfoDto != null) {
                result = new ApiResponse(true, "성공", userInfoDto);
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "아이디나 비밀번호가 없습니다.", userInfoDto);
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
//    public UserInfoDto signin(@RequestBody UserSignInDto userSignInDto) {
//        return usersService.signIn(userSignInDto);
//    }
}