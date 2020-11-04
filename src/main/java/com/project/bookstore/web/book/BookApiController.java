package com.project.bookstore.web.book;

import com.project.bookstore.config.ApiResponse;
import com.project.bookstore.service.books.BooksService;
import com.project.bookstore.web.book.dto.BookInsertDto;
import com.project.bookstore.web.book.dto.BookUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "도서", description = "도서 관리", tags = { "도서" })
@RequestMapping("/books")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class BookApiController {
    private final BooksService booksService;

    @ApiOperation(value = "도서등록")
    @PostMapping("/bookInsert")
    public ResponseEntity<?> bookInsert(@RequestBody BookInsertDto bookInsertDto) {
        ApiResponse result = null;
        try {
            if(bookInsertDto.getIsbn() != null) {
                result = new ApiResponse(true, "성공", booksService.bookInsert(bookInsertDto));
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "실패", null);
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서 수정")
    @PutMapping("/update/{isbn}")
    public ResponseEntity<?> bookUpdate(@PathVariable("isbn") String isbn, @RequestParam BookUpdateDto updateDto) {
        ApiResponse result = null;
        try{
            result = new ApiResponse(true, "성공", booksService.update(isbn, updateDto));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(true, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "도서 검색")
    @PostMapping("/bookSearch")
    public ResponseEntity<?> bookSearch(@RequestParam("searchWhat") String searchWhat, @RequestParam("searchKey") String searchKey) {
        ApiResponse result = null;
        System.out.println(searchWhat);
        try{
            if (searchWhat.equals("bookName")) {
                result = new ApiResponse(true, "성공", booksService.bookName(searchKey));
                return ResponseEntity.ok().body(result);
            } else if (searchWhat.equals("bookAuthor")) {
                result = new ApiResponse(true, "성공", booksService.bookAuthor(searchKey));
                return ResponseEntity.ok().body(result);
            } else {
                result = new ApiResponse(false, "실패", null);
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

}
