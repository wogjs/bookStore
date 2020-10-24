package com.project.bookstore.domain.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardsRepository extends JpaRepository<Cards, String> {
    @Query("SELECT c FROM Cards c WHERE c.usersID = ?1")
    List<Cards> findAll(String usersID);


    @Query("SELECT c FROM Cards c WHERE c.usersID = ?1 AND c.cardNum = ?2")
    List<Cards> findByCard(String usersID, String cardNum);
}
