package com.project.bookstore.web.orders;

import java.util.List;

import com.project.bookstore.service.books.BooksService;
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
    private final BooksService booksService;
    private final UserInfo userInfo;

    @GetMapping("/orders/Pay")
    public String orderBook(@RequestParam("isbn") String isbn, @RequestParam("oa") Long oa, Model model) { 
        model.addAttribute("bookInfo", booksService.findBook(isbn));
        model.addAttribute("cardInfo", cardService.findCard(userInfo));
        model.addAttribute("addrInfo", addrService.findAddr(userInfo));
        model.addAttribute("userid", usersService.findUsers(userInfo));
        model.addAttribute("order", oa);
        System.out.println(oa);
        return "orders/orders";
    }

    @GetMapping("/orders/cart/Pay")
    public String orderCart(@RequestParam("isbn") List<String> isbn, @RequestParam("oa") List<Integer> oa, Model model) { 
        model.addAttribute("bookInfo", booksService.findBookList(isbn));
        model.addAttribute("cardInfo", cardService.findCard(userInfo));
        model.addAttribute("addrInfo", addrService.findAddr(userInfo));
        model.addAttribute("userid", usersService.findUsers(userInfo));
        model.addAttribute("order", oa);
        System.out.println(oa);
        return "orders/orders";
    }
}
