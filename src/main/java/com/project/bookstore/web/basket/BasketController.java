package com.project.bookstore.web.basket;

import com.project.bookstore.service.basket.BasketService;
import com.project.bookstore.session.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BasketController {
    private final BasketService basketService;
    private final UserInfo userInfo;

    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("basInfo", basketService.infoList());
        model.addAttribute("userid", basketService.findUsers(userInfo));
        return "users/basket";
    }
}
