package com.project.bookstore.web.book;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.book.dto.BookInsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BooksService booksService;
    private final UserInfo userInfo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userid", userInfo.getUserId());
        model.addAttribute("bookInfo", booksService.findAll());
        return "index";
    }

    @GetMapping("/books/bookInsert")
    public String booksInsert() {
        return "books/bookInsert";
    }

    @GetMapping("/books/bookInfo")
//    public String bookInfo (Model model) {
//        model.addAttribute("books", booksService.findAll());
//
//        return "books/bookInfo";
//    }
    public ResponseEntity<?> bookInfo(Model model) {
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "성공", booksService.findAll());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

//    public ResponseEntity<?> bookInsert(@RequestBody BookInsertDto bookInsertDto) {
//        ApiResponse result = null;
//        try {
//            if(bookInsertDto.getIsbn() != null) {
//                result = new ApiResponse(true, "성공", booksService.bookInsert(bookInsertDto));
//                return ResponseEntity.ok().body(result);
//            } else {
//                result = new ApiResponse(false, "실패", null);
//                return ResponseEntity.badRequest().body(result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = new ApiResponse(false, e.getMessage(), null);
//            return ResponseEntity.badRequest().body(result);
//        }
//    }
}
