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
    private String usersID;
    private String addrName;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private String addrNum;
    private String addrYN;
    private String addrNic;
    private String secNum;

    @Builder
    public AddrInsertDto (String usersID, String addrName, Long addrZip,
                 String addrBas, String addrDet, String addrNum, String addrYN, String addrNic, String secNum){
        this.usersID = usersID;
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
        this.addrNum = addrNum;
        this.addrYN = addrYN;
        this.addrNic = addrNic;
        this.secNum = secNum;
    }

    public Addr toEntity() {
        return Addr.builder()
                .usersID(usersID)
                .addrName(addrName)
                .addrZip(addrZip)
                .addrBas(addrBas)
                .addrDet(addrDet)
                .addrNum(addrNum)
                .addrYN(addrYN)
                .addrNic(addrNic)
                .secNum(secNum)
                .build();
    }
}
