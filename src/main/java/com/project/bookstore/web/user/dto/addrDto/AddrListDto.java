package com.project.bookstore.web.user.dto.addrDto;

import com.project.bookstore.domain.addr.Addr;
import com.project.bookstore.domain.users.Users;
import lombok.Getter;

@Getter
public class AddrListDto {
    private Long addrCode;
    private String addrName;
    private Users users;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private String addrNum;
    private String addrYN;
    private String addrNic;

    public AddrListDto(Addr entity) {
        this.addrCode = entity.getAddrCode();
        this.addrName = entity.getAddrName();
        this.users = entity.getUsers();
        this.addrZip = entity.getAddrZip();
        this.addrBas = entity.getAddrBas();
        this.addrDet = entity.getAddrDet();
        this.addrNum = entity.getAddrNum();
        this.addrYN = entity.getAddrYN();
        this.addrNic = entity.getAddrNic();
    }
}
