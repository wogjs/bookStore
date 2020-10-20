package com.project.bookstore.web.user;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.config.ApiResponse2;
import com.project.bookstore.service.users.UsersService;
import com.project.bookstore.web.user.dto.cardDto.CardInsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

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
    public ResponseEntity<?> mypage(@PathVariable("id") String users_ID) {
//        model.addAttribute("userInfo", usersService.findAll(users_id));
        ApiResponse2 result = null;
        try{
            result = new ApiResponse2(true, "성공", usersService.findById(users_ID), usersService.findCard(users_ID), usersService.findAddr(users_ID));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse2(false, e.getMessage(), null,null, null);
            return  ResponseEntity.badRequest().body(result);
        }
    }

}