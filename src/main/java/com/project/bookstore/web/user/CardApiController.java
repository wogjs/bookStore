package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Api(value = "카드", description = "카드 관리", tags = { "카드" })
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class CardApiController {

    private final CardService cardService;
    private final UserInfo userInfo;

    @ApiOperation(value = "카드 등록")
    @PostMapping("/card")
    public ResponseEntity<?> cardInsert(@RequestBody CardInsertDto insertDto) {
        ApiResponse result = null;
        if (insertDto.getCardNum() != null) {
            try {
                if(insertDto.getCardNum() != null) {
                    insertDto.setUsers(cardService.findUsers(userInfo));
                    result = new ApiResponse(true, "성공", cardService.cardSave(insertDto));
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

    @ApiOperation(value = "카드 삭제")
    @PostMapping("/card/delete/{cardNum}")
    public RedirectView cardDelete(@PathVariable String cardNum) {
        cardService.cardDelete(cardNum);
        return new RedirectView("/users/mypage");

    }
}
