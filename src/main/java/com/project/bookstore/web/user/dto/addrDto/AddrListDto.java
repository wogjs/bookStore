package com.project.bookstore.web.user.dto.addrDto;

import com.project.bookstore.domain.addr.Addr;
import lombok.Getter;

@Getter
public class AddrListDto {
    private String addr_Name;
    private Long addr_Zip;
    private String addr_Bas;
    private String addr_Det;
    private String addr_Num;
    private String addr_YN;
    private String addr_Nic;
    private String sec_Num;

    public AddrListDto(Addr entity) {
        this.addr_Name = entity.getAddr_Name();
        this.addr_Zip = entity.getAddr_Zip();
        this.addr_Bas = entity.getAddr_Bas();
        this.addr_Det = entity.getAddr_Det();
        this.addr_Num = entity.getAddr_Num();
        this.addr_YN = entity.getAddr_YN();
        this.addr_Nic = entity.getAddr_Nic();
        this.sec_Num = entity.getSec_Num();
    }
}
