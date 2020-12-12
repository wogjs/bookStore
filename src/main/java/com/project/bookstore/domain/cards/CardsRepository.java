package com.project.bookstore.domain.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, String> {
    List<Cards> findAllByUsers_Id(String userid);
}
