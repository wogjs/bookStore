package com.project.bookstore.web.user.dto.addrDto;

import com.project.bookstore.domain.addr.Addr;
import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddrInsertDto {
    private Users users;
    private String addrName;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private String addrNum;
    private String addrYN;
    private String addrNic;

    @Builder
    public AddrInsertDto(Users users, String addrName, Long addrZip, String addrBas, String addrDet, String addrNum,
            String addrYN, String addrNic) {
        this.users = users;
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
        this.addrNum = addrNum;
        this.addrYN = addrYN;
        this.addrNic = addrNic;
    }

    public Addr toEntity() {
        return Addr.builder().users(users).addrName(addrName).addrZip(addrZip).addrBas(addrBas).addrDet(addrDet)
                .addrNum(addrNum).addrYN(addrYN).addrNic(addrNic).build();
    }
}
