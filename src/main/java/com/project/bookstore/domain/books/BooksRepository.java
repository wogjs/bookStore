package com.project.bookstore.domain.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, String> {

    @Query("SELECT p FROM Books p ORDER BY p.isbn DESC")
    List<Books> findAllDesc();
}
