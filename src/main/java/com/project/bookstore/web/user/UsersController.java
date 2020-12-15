package com.project.bookstore.web.user;

import com.project.bookstore.service.orders.OrderService;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.session.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final AddrService addrService;
    private final CardService cardService;
    private final OrderService orderService;
    private final UserInfo userInfo;

    @GetMapping("/users/signup")
    public String signUp() {
        return "users/SignUp";
    }

    @GetMapping("/users/login")
    public String signIn() {
        return "users/signIn";
    }

    @GetMapping("/users/mypage")
    public String mypage(Model model) {
        model.addAttribute("userid", userInfo.getUserId());
        model.addAttribute("cardInfo", cardService.findCard(userInfo));
        model.addAttribute("addrInfo", addrService.findAddr(userInfo));
        model.addAttribute("orderList", orderService.listRead());
        return "users/mypage";
    }

    @GetMapping("/users/addr")
    public String addr() {
        return "users/addr";
    }

    // @GetMapping("/users/mypage/{id}")
    // public ResponseEntity<?> mypage() {
    //// model.addAttribute("userInfo", usersService.findAll(users_id));
    // ApiResponse2 result = null;
    // try{
    // result = new ApiResponse2(true, "성공", usersService.findUsers(userInfo),
    // cardService.findCard(userInfo), addrService.findAddr(userInfo));
    // return ResponseEntity.ok().body(result);
    // } catch (Exception e) {
    // e.printStackTrace();
    // result = new ApiResponse2(false, e.getMessage(), null,null, null);
    // return ResponseEntity.badRequest().body(result);
    // }
    // }

}