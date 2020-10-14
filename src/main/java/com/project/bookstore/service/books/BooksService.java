package com.project.bookstore.service.books;

import com.project.bookstore.domain.book.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BooksService {
    private BooksRepository booksRepository;
}
