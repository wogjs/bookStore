package com.project.bookstore.domain.users;

import com.project.bookstore.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUserID(String userID);
}
