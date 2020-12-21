package com.project.bookstore.web.book;

import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.session.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BookController {
    private final BooksService booksService;
    private final UserInfo userInfo;

    @GetMapping("/")
    public String index(Model model) {
        if(userInfo.getUserId() != null) {
            if(userInfo.getUserId().equals("master")) {
                model.addAttribute("master", userInfo.getUserId());
            } 
        }
        model.addAttribute("userid", userInfo.getUserId());
        model.addAttribute("bookInfo", booksService.findAll());
        return "index";
    }

    @GetMapping("/bookSearch")
    public String bookSearch(@RequestParam("searchWhat") String searchWhat, @RequestParam("searchKey") String searchKey, Model model) {
        System.out.println("드렁왔는가");
        System.out.println(searchWhat);
        System.out.println(searchKey);
        if (searchWhat.equals("bookName")) {
            model.addAttribute("bookInfo", booksService.bookName(searchKey));
        } else if (searchWhat.equals("bookAuthor")) {
            model.addAttribute("bookInfo", booksService.bookAuthor(searchKey));
        } 
        return "index";
    }

    @GetMapping("/books/bookInsert")
    public String booksInsert() {
        return "books/bookInsert";
    }

    @GetMapping("/books/bookInfo/{isbn}")
    public String bookInfo(@PathVariable String isbn, Model model) {
        if(userInfo.getUserId() != null) {
            if(userInfo.getUserId().equals("master")) {
                model.addAttribute("master", userInfo.getUserId());
            } 
        }
        model.addAttribute("userid", userInfo.getUserId());
        model.addAttribute("bookInfo", booksService.findBook(isbn));
        return "books/bookInfo";
    }

    @GetMapping("/books/update/{isbn}")
    public String bookUpdate(@PathVariable String isbn, Model model) {
        model.addAttribute("userid", userInfo.getUserId());
        model.addAttribute("bookInfo", booksService.findBook(isbn));
        return "books/bookUpdate";
    }
    // public ResponseEntity<?> bookInfo(Model model) {
    // ApiResponse result = null;
    // try {
    // result = new ApiResponse(true, "성공", booksService.findAll());
    // return ResponseEntity.ok().body(result);
    // } catch (Exception e) {
    // e.printStackTrace();
    // result = new ApiResponse(false, e.getMessage(), null);
    // return ResponseEntity.badRequest().body(result);
    // }
    // }

    // public ResponseEntity<?> bookInsert(@RequestBody BookInsertDto bookInsertDto)
    // {
    // ApiResponse result = null;
    // try {
    // if(bookInsertDto.getIsbn() != null) {
    // result = new ApiResponse(true, "성공", booksService.bookInsert(bookInsertDto));
    // return ResponseEntity.ok().body(result);
    // } else {
    // result = new ApiResponse(false, "실패", null);
    // return ResponseEntity.badRequest().body(result);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // result = new ApiResponse(false, e.getMessage(), null);
    // return ResponseEntity.badRequest().body(result);
    // }
    // }
}
