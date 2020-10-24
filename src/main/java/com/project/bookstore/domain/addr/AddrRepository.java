package com.project.bookstore.domain.addr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface AddrRepository extends JpaRepository<Addr, Long> {
//    Optional<Addr> findById(String id);

    @Query("SELECT a FROM Addr a WHERE a.users_ID = ?1")
    List<Addr> findAll(String users_ID);

    @Modifying
    @Query("UPDATE Addr a SET a.addr_YN = 'N' WHERE a.addr_YN = 'Y' AND a.users_ID = ?1")
    void updateAddrYN(String users_ID);
}
