package com.project.bookstore.domain.addr;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Addr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrCode;

    @Column(name = "Users_id")
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
    public Addr (String usersID, String addrName, Long addrZip,
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


}
