package com.project.bookstore.domain.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardsRepository extends JpaRepository<Cards, String> {
    @Query("SELECT c FROM Cards c WHERE c.users_ID = ?1")
    List<Cards> findAll(String users_ID);


    @Query("SELECT c FROM Cards c WHERE c.users_ID = ?1 AND c.card_Num = ?2")
    List<Cards> findByCard(String users_ID, String card_Num);
}
