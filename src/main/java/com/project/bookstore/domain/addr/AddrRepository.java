package com.project.bookstore.domain.addr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddrRepository extends JpaRepository<Addr, Long> {
    // Optional<Addr> findById(String id);

    List<Addr> findAllByUsers_Id(String userid);

    @Query("SELECT a FROM Addr a WHERE a.addrYN = 'Y'")
    List<Addr> findAllDesc();

    List<Addr> findByUsers_IdAndAddrYN(String userid, String YN);
}
