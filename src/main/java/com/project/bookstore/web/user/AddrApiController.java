package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "주소", description = "주소 관리", tags = { "주소" })
@RequestMapping("/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class AddrApiController {
    private final AddrService addrService;

    @ApiOperation(value = "주소지 등록")
    @PostMapping("/mypage/addr/{id}")
    public ResponseEntity<?> addrInsert(@PathVariable("id") String id, @RequestBody AddrInsertDto insertDto) {
        ApiResponse result = null;
        try {
            if(insertDto.getAddrZip() != null) {
                System.out.println(insertDto.getAddrYN());
                if(insertDto.getAddrYN() == null) {
                    if(addrService.findAddr(id).isEmpty()){
                        insertDto.setAddrYN("Y");
                    } else {
                        insertDto.setAddrYN("N");
                    }
                } else {
                    if (!addrService.findAddr(id).isEmpty()){
                        addrService.addrUpdateYN(id);
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
                result = new ApiResponse(true, "성공", addrService.addrSave(insertDto));
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
}
