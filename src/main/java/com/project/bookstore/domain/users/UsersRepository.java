package com.project.bookstore.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
//    @Query("SELECT p FROM Users p ORDER BY p.id DESC")
//    List<Users> findAll();

    Optional<Users> findById(String id);

}
