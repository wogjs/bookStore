package com.project.bookstore.web.orders;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.domain.books.Books;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.orders.OrderService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.orders.dto.InfoInsertDto;
import com.project.bookstore.web.orders.dto.OrderDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "주문", description = "주문 관리", tags = { "주문" })
@RequestMapping("/orders")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class OrderApiController {

    private final OrderService orderService;
    private final UsersService usersService;
    private final CardService cardService;
    private final AddrService addrService;
    private final BooksService booksService;
    private final UserInfo userInfo;

    @ApiOperation(value = "주문")
    @PostMapping("/orderPay")
    public ResponseEntity<?> orders(@RequestParam("isbn") String isbn, @RequestParam("oa") Long oa, @RequestBody OrderDto insertDto, InfoInsertDto infoInsertDto) {
        System.out.println("들어왔는가");
        ApiResponse result = null;
        String cardNum = insertDto.getCardNum();
        Long addrCode = insertDto.getAddrCode();
        // 주문리스트
        insertDto.setUsers(usersService.findUsers(userInfo));
        insertDto.setCardPeriod(cardService.findCardNum(cardNum).getCardPeriod());
        insertDto.setCardVal(cardService.findCardNum(cardNum).getCardVal());
        insertDto.setOrderBas(addrService.findAddrCode(addrCode).getAddrBas());
        insertDto.setOrderDet(addrService.findAddrCode(addrCode).getAddrDet());
        insertDto.setOrderZip(addrService.findAddrCode(addrCode).getAddrZip());
        // 주문상세리스트
        infoInsertDto.setOrderAmount(oa);
        infoInsertDto.setBooks(booksService.findBook(isbn));
        // 도서 수정
        Books books = new Books();
        books = booksService.findBook(isbn);
        Long updateBookSto =  books.getBookSto() - oa;
        booksService.updateSto(isbn, updateBookSto);
        
        try {
            orderService.orderInsert(insertDto);
            orderService.infoInsert(isbn, infoInsertDto);
            result = new ApiResponse(true, "성공", null);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

}
