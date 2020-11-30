package com.project.bookstore.web.orders;

import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.service.orders.OrderService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/orders")
    public String orderBook(@RequestParam("isbn") String isbn, @RequestParam("os") Long os, Model model) {
        model.addAttribute("bookInfo", booksService.findBook(isbn));
        model.addAttribute("cardInfo", cardService.findCard(userInfo));
        model.addAttribute("addrInfo", addrService.findAddr(userInfo));
        model.addAttribute("userid", usersService.findUsers(userInfo));
        model.addAttribute("order", os);
        System.out.println(os);
        return "orders/orders";
    }

}
