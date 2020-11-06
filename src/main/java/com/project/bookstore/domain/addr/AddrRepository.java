package com.project.bookstore.domain.addr;

import com.project.bookstore.session.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface AddrRepository extends JpaRepository<Addr, String> {
//    Optional<Addr> findById(String id);

    List<Addr> findAllByUsers_Id(String userid);

    @Query("SELECT a FROM Addr a WHERE a.addrYN = 'Y'")
    List<Addr> findAllDesc();

    List<Addr> findByUsers_IdAndAddrYN(String userid, String YN);
}
