package com.project.bookstore.domain.addr;

import com.project.bookstore.session.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface AddrRepository extends JpaRepository<Addr, Long> {
//    Optional<Addr> findById(String id);

    @Query("SELECT a FROM Addr a WHERE a.users = ?1")
    List<Addr> findAll(UserInfo userInfo);

    @Modifying
    @Query("UPDATE Addr a SET a.addrYN = 'N' WHERE a.addrYN = 'Y' AND a.users = ?1")
    void updateAddrYN(UserInfo userInfo);
}
