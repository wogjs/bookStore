package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "카드", description = "카드 관리", tags = { "카드" })
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class CardApiController {

    private final CardService cardService;

    @ApiOperation(value = "카드 등록")
    @PostMapping("/mypage/cards/{id}")
    public ResponseEntity<?> cardInsert(@PathVariable("id") String id, @RequestBody CardInsertDto insertDto) {
        ApiResponse result = null;
        if (cardService.findByCard(id, insertDto.getCardNum()).isEmpty()) {
            try {
                if(insertDto.getCardNum() != null) {
                    insertDto.setUsersID(id);
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
}
