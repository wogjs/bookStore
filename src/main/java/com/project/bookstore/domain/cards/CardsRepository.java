package com.project.bookstore.domain.cards;

import com.project.bookstore.domain.users.Users;
import com.project.bookstore.session.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardsRepository extends JpaRepository<Cards, String> {
    @Query("SELECT c FROM Cards c WHERE c.users = ?1")
    List<Cards> findAll(UserInfo userInfo);


    @Query("SELECT c FROM Cards c WHERE c.users = ?1 AND c.cardNum = ?2")
    List<Cards> findByCard(UserInfo userInfo, String cardNum);
}
