package com.project.bookstore.service.books;

import com.project.bookstore.domain.books.BooksRepository;
import com.project.bookstore.web.book.dto.BookInsertDto;
import com.project.bookstore.web.book.dto.BookListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<BookListDto> findAllDesc() {
        return  booksRepository.findAllDesc().stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    // 책 검색
    @Transactional
    public List<BookListDto> bookName(String searchKey) {
        return booksRepository.findByBookNameContaining(searchKey).stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BookListDto> bookAuthor (String searchKey) {
        return booksRepository.findByBookAutContaining(searchKey).stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }

}
