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

    @Transactional
    public String bookInsert(BookInsertDto bookInsertDto) {
        System.out.println("+==============================");

        System.out.println("+==============================");
        System.out.println(bookInsertDto.toEntity().getIsbn());
        System.out.println("+==============================");
        return booksRepository.save(bookInsertDto.toEntity()).getIsbn();
    }

    @Transactional
    public List<BookListDto> findAllDesc() {
        return  booksRepository.findAllDesc().stream()
                .map(BookListDto::new)
                .collect(Collectors.toList());
    }
}
