package com.project.bookstore.domain.addr;

import com.project.bookstore.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Addr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrCode;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    private String addrName;
    private Long addrZip;
    private String addrBas;
    private String addrDet;
    private String addrNum;
    private String addrYN;
    private String addrNic;

    @Builder
    public Addr (Users users, String addrName, Long addrZip,
                 String addrBas, String addrDet, String addrNum, String addrYN, String addrNic){
        this.users = users;
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
        this.addrNum = addrNum;
        this.addrYN = addrYN;
        this.addrNic = addrNic;
    }

    public void YNupdate(Long addrCode, String addrYN){
        this.addrCode = addrCode;
        this.addrYN = addrYN;
    }

    public void update(String addrName, Long addrZip, String addrBas, String addrDet, String addrNum, String addrYN, String addrNic) {
        this.addrName = addrName;
        this.addrZip = addrZip;
        this.addrBas = addrBas;
        this.addrDet = addrDet;
        this.addrNum = addrNum;
        this.addrYN = addrYN;
        this.addrNic = addrNic;
    }

}
