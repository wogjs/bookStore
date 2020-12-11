package com.project.bookstore.web.basket;

import java.util.List;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.basket.BasketService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.basket.dto.BasketInsertDto;
import com.project.bookstore.web.basket.dto.InfoInsertDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(value = "장바구니", description = "장바구니 관리", tags = { "장바구니" })
@RequestMapping("/basket")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class BasketApiController {
    private final BasketService basketService;
    private final UserInfo userInfo;

    @ApiOperation(value = "장바구니 추가")
    @PostMapping("/{isbn}")
    public ResponseEntity<?> basketInsert(@PathVariable("isbn") String isbn, @RequestBody InfoInsertDto insertDto,
            BasketInsertDto basketInsertDto) {
        ApiResponse result = null;
        try {
            if (basketService.basketFind(userInfo) == false) {
                basketInsertDto.setUsers(basketService.findUsers(userInfo));
                basketService.basInsert(basketInsertDto);
            }
            System.out.println(insertDto.getBasAmount());
            result = new ApiResponse(true, "성공", basketService.infoInsert(isbn, insertDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "장바구니 삭제")
    @GetMapping("/delete")
    public RedirectView delete(@RequestParam("isbn") List<String> isbn) {
        Long basCode = basketService.basCode();
        for(int i = 0; i < isbn.size(); i++) {
            basketService.basketBookDel(basCode, isbn.get(i));
        }
        return new RedirectView("/basket");
    }
    
    @ApiOperation(value = "테스트")
    @GetMapping("/order")
    public void orderPush(@RequestParam("isbn") List<String> isbn, @RequestParam("oa") List<Integer> oa) {
        for(int i = 0; i < isbn.size(); i++) {
            System.out.print("ISBN : ");
            System.out.println(isbn.get(i));
            System.out.print("oa : ");
            System.out.println(oa.get(i));
        }
        
        // return new RedirectView("/basket");
    }

}
