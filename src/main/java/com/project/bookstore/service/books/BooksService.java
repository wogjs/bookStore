package com.project.bookstore.service.books;

import com.project.bookstore.domain.books.Books;
import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.web.book.dto.BookInsertDto;
import com.project.bookstore.web.book.dto.BookListDto;
import com.project.bookstore.web.book.dto.BookUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;

    // 책 삽입
    @Transactional
    public String bookInsert(BookInsertDto bookInsertDto) {
        return booksRepository.save(bookInsertDto.toEntity()).getIsbn();
    }

    // 책 리스트 출력
    @Transactional
    public List<BookListDto> findAll() {
        return booksRepository.findAll().stream().map(BookListDto::new).collect(Collectors.toList());
    }

    // 책 isbn 찾기 
    @Transactional
    public Books findBook(String isbn) {
        return booksRepository.findById(isbn).get();
    }

    // 책 이름으로 검색
    @Transactional
    public List<BookListDto> bookName(String searchKey) {
        return booksRepository.findByBookNameContaining(searchKey).stream().map(BookListDto::new)
                .collect(Collectors.toList());
    }

    // 책 저자로 검색
    @Transactional
    public List<BookListDto> bookAuthor(String searchKey) {
        return booksRepository.findByBookAutContaining(searchKey).stream().map(BookListDto::new)
                .collect(Collectors.toList());
    }

    // 책 업데이트
    @Transactional
    public Books update(String isbn, BookUpdateDto updateDto) {
        Books books = booksRepository.findById(isbn).orElseThrow(() -> new IllegalArgumentException("에러"));

        books.update(updateDto.getBookAut() ,updateDto.getBookTrans(), updateDto.getBookCov(), updateDto.getBookPri(), updateDto.getBookDet(),
                updateDto.getBookSto());

        return books;
    }

    @Transactional
    public void updateSto(String isbn, Long updateSto) {
        Books books = booksRepository.findById(isbn).orElseThrow(() -> new IllegalArgumentException("에러"));

        books.updateSto(updateSto);
    }

}
