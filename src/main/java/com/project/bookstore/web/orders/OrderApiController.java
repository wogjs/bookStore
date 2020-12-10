package com.project.bookstore.web.orders;

import java.util.List;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.domain.addr.Addr;
import com.project.bookstore.domain.books.Books;
import com.project.bookstore.domain.cards.Cards;
import com.project.bookstore.service.basket.BasketService;
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
    private final BasketService basketService;
    private final UserInfo userInfo;

    @ApiOperation(value = "바로주문")
    @PostMapping("/Pay")
    public ResponseEntity<?> orders(@RequestParam("isbn") String isbn, @RequestParam("oa") Long oa, @RequestBody OrderDto insertDto, InfoInsertDto infoInsertDto) {
        System.out.println("들어왔는가");
        ApiResponse result = null;

        String cardNum = insertDto.getCardNum();
        Long addrCode = insertDto.getAddrCode();
        Cards cards = new Cards();
        Addr addr = new Addr();
        cards = cardService.findCardNum(cardNum);
        addr = addrService.findAddrCode(addrCode);

        // 주문리스트
        insertDto.setUsers(usersService.findUsers(userInfo));
        insertDto.setCardPeriod(cards.getCardPeriod());
        insertDto.setCardVal(cards.getCardVal());
        insertDto.setOrderBas(addr.getAddrBas());
        insertDto.setOrderDet(addr.getAddrDet());
        insertDto.setOrderZip(addr.getAddrZip());
               
        try {
            // 주문상세리스트
            infoInsertDto.setOrderAmount(oa);
            infoInsertDto.setBooks(booksService.findBook(isbn));
                
            // 도서 수정
            Books books = new Books();
            books = booksService.findBook(isbn);
            Long updateBookSto =  books.getBookSto() - oa;
            booksService.updateSto(isbn, updateBookSto);

            // 주문
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
    
    @ApiOperation(value = "장바구니 주문")
    @PostMapping("/cart/Pay")
    public ResponseEntity<?> basketOrder(@RequestParam("isbn") List<String> isbn, @RequestParam("oa") List<Long> oa, @RequestBody OrderDto insertDto, InfoInsertDto infoInsertDto) {
        System.out.println("들어왔는가");
        ApiResponse result = null;

        String cardNum = insertDto.getCardNum();
        Long addrCode = insertDto.getAddrCode();
        Cards cards = new Cards();
        Addr addr = new Addr();
        cards = cardService.findCardNum(cardNum);
        addr = addrService.findAddrCode(addrCode);

        // 주문리스트
        insertDto.setUsers(usersService.findUsers(userInfo));
        insertDto.setCardPeriod(cards.getCardPeriod());
        insertDto.setCardVal(cards.getCardVal());
        insertDto.setOrderBas(addr.getAddrBas());
        insertDto.setOrderDet(addr.getAddrDet());
        insertDto.setOrderZip(addr.getAddrZip());

        try {
            orderService.orderInsert(insertDto);
            
            // 주문상세리스트
            for (int i =0; i < oa.size(); i++) {
                // 주문상세리스트
                infoInsertDto.setOrderAmount(oa.get(i));
                infoInsertDto.setBooks(booksService.findBook(isbn.get(i)));
                
                // 도서 수정
                Books books = new Books();
                books = booksService.findBook(isbn.get(i));
                Long updateBookSto =  books.getBookSto() - oa.get(i);
                booksService.updateSto(isbn.get(i), updateBookSto);

                //주문
                orderService.infoInsert(isbn.get(i), infoInsertDto);

                // 장바구니 삭제
                basketService.basketBookDel(basketService.basCode(), isbn.get(i));
                
            }
            result = new ApiResponse(true, "성공", null);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
