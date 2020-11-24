package com.project.bookstore.web.orders;

import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.orders.OrderService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.orders.dto.SumDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final UsersService usersService;
    private final CardService cardService;
    private final AddrService addrService;
    private final OrderService orderService;
    private final BooksService booksService;
    private final UserInfo userInfo;

    @GetMapping("/orders/{isbn}")
    public String orderBook(@PathVariable("isbn") String isbn, SumDto sumDto, Model model) {
        System.out.println("111111111111111111111");
        model.addAttribute("bookInfo", booksService.findBook(isbn));
        System.out.println("22222222222222222222");
        model.addAttribute("cardInfo", cardService.findCard(userInfo));
        System.out.println("33333333333333333333");
        model.addAttribute("addrInfo", addrService.findAddr(userInfo));
        System.out.println("444444444444444444444");
        model.addAttribute("sum", sumDto);

        return "orders/orders";
    }

}
