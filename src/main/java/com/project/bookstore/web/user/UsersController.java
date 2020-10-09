package com.project.bookstore.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users/signUp")
    public String signUp() {
        return "signUp";
    }
}
