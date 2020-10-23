package com.project.bookstore.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, String> {

    @Query("SELECT b FROM Books b ORDER BY b.isbn DESC")
    List<Books> findAllDesc();

    // 도서 검색
    // Like문 정리 || Like "A" || Contaning "%A%" || StartingWith "A%" || EndingWith "%A"
    List<Books> findByBookNameContaining(String bookName);

    List<Books> findByBookAutContaining(String bookAut);

}
