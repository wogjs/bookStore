package com.project.bookstore.domain.addr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddrRepository extends JpaRepository<Addr, Long> {
//    Optional<Addr> findById(String id);

    @Query("SELECT a FROM Addr a WHERE a.users_ID = ?1")
    List<Addr> findAll(String users_ID);
}
