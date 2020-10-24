package com.project.bookstore.web.user.dto.addrDto;

import com.project.bookstore.domain.addr.Addr;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
public class AddrInsertDto {
    private String users_ID;
    private String addr_Name;
    private Long addr_Zip;
    private String addr_Bas;
    private String addr_Det;
    private String addr_Num;
    private String addr_YN;
    private String addr_Nic;
    private String sec_Num;

    @Builder
    public AddrInsertDto (String users_ID, String addr_Name, Long addr_Zip,
                 String addr_Bas, String addr_Det, String addr_Num, String addr_YN, String addr_Nic, String sec_Num){
        this.users_ID = users_ID;
        this.addr_Name = addr_Name;
        this.addr_Zip = addr_Zip;
        this.addr_Bas = addr_Bas;
        this.addr_Det = addr_Det;
        this.addr_Num = addr_Num;
        this.addr_YN = addr_YN;
        this.addr_Nic = addr_Nic;
        this.sec_Num = sec_Num;
    }

    public Addr toEntity() {
        return Addr.builder()
                .users_ID(users_ID)
                .addr_Name(addr_Name)
                .addr_Zip(addr_Zip)
                .addr_Bas(addr_Bas)
                .addr_Det(addr_Det)
                .addr_Num(addr_Num)
                .addr_YN(addr_YN)
                .addr_Nic(addr_Nic)
                .sec_Num(sec_Num)
                .build();
    }
}
