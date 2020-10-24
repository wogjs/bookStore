package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
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

    @ApiOperation(value = "카드 등록")
    @PostMapping("/mypage/cards/{id}")
    public ResponseEntity<?> cardInsert(@PathVariable("id") String id, @RequestBody CardInsertDto insertDto) {
        ApiResponse result = null;
        if (usersService.findByCard(id, insertDto.getCardNum()).isEmpty()) {
            try {
                if(insertDto.getCardNum() != null) {
                    insertDto.setUsersID(id);
                    result = new ApiResponse(true, "성공", usersService.cardSave(insertDto));
                    return ResponseEntity.ok().body(result);
                } else {
                    result = new ApiResponse(false, "실패", null);
                    return ResponseEntity.badRequest().body(result);
                }
            }catch (Exception e) {
                e.printStackTrace();
                result = new ApiResponse(false, e.getMessage(), null);
                return ResponseEntity.badRequest().body(result);
            }
        } else {
            result = new ApiResponse(false,"이미 등록된 카드입니다.", null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "주소지 등록")
    @PostMapping("/mypage/addr/{id}")
    public ResponseEntity<?> addrInsert(@PathVariable("id") String id, @RequestBody AddrInsertDto insertDto) {
        ApiResponse result = null;
        try {
            if(insertDto.getAddrZip() != null) {
                System.out.println(insertDto.getAddrYN());
                if(insertDto.getAddrYN() == null) {
                    if(usersService.findAddr(id).isEmpty()){
                        insertDto.setAddrYN("Y");
                    } else {
                        insertDto.setAddrYN("N");
                    }
                } else {
                    if (!usersService.findAddr(id).isEmpty()){
                        usersService.addrUpdateYN(id);
                    }
                    insertDto.setAddrYN("Y");
                }
                if (insertDto.getAddrNic() == null) {
                    insertDto.setAddrNic(null);
                }
                if (insertDto.getSecNum() == null) {
                    insertDto.setSecNum(null);
                }
                insertDto.setUsersID(id);
                result = new ApiResponse(true, "성공", usersService.addrSave(insertDto));
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
}