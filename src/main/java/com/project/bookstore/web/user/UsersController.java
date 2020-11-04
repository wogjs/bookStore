package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse2;
import com.project.bookstore.service.users.AddrService;
import com.project.bookstore.service.users.CardService;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.session.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;
    private final AddrService addrService;
    private final CardService cardService;
    private final UserInfo userInfo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users/signUp")
    public String signUp() {
        return "users/SignUp";
    }

    @GetMapping("/users/login")
    public String signIn() {
        return "users/signIn";
    }

//    @GetMapping("/users/mypage/{id}")
//    public String mypage(@PathVariable("id") String users_id, Model model) {
//        model.addAttribute("userInfo", usersService.findAll(users_id));
//
//        return "users/mypage";
//    }

    @GetMapping("/users/mypage/{id}")
    public ResponseEntity<?> mypage() {
//        model.addAttribute("userInfo", usersService.findAll(users_id));
        ApiResponse2 result = null;
        try{
            result = new ApiResponse2(true, "성공", usersService.findUsers(userInfo), cardService.findCard(userInfo), addrService.findAddr(userInfo));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse2(false, e.getMessage(), null,null, null);
            return  ResponseEntity.badRequest().body(result);
        }
    }

}