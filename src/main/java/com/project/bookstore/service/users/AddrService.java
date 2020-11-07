package com.project.bookstore.service.users;

import com.project.bookstore.domain.addr.Addr;
import com.project.bookstore.domain.addr.AddrRepository;
import com.project.bookstore.domain.users.Users;
import com.project.bookstore.domain.users.UsersRepository;
import com.project.bookstore.session.UserInfo;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import com.project.bookstore.web.user.dto.addrDto.AddrListDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddrService {

    private final AddrRepository addrRepository;
    private final UsersRepository usersRepository;


    @Transactional(readOnly = true)
    public Users findUsers(UserInfo userInfo){
        return usersRepository.findById(userInfo.getUserId()).get();
    }

    // 주소 등록
    @Transactional
    public Long addrSave(AddrInsertDto insertDto) {
        return addrRepository.save(insertDto.toEntity()).getAddrZip();
    }

    // 주소 조회
    @Transactional
    public List<AddrListDto> findAddr(UserInfo userInfo) {
        return addrRepository.findAllByUsers_Id(userInfo.getUserId()).stream()
                .map(AddrListDto::new)
                .collect(Collectors.toList());
    }

    // 기본 배송지 변경
    @Transactional
    public List<AddrListDto> YN(UserInfo userInfo) {
        return addrRepository.findByUsers_IdAndAddrYN(userInfo.getUserId(),"Y").stream()
                .map(AddrListDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public Addr addrUpdateYN(UserInfo userInfo){
        Addr addr = addrRepository.findByUsers_IdAndAddrYN(userInfo.getUserId(), "Y").get(0);
        addr.setAddrYN("N");
        System.out.println(addr.getAddrYN());
        addr.YNupdate(addr.getAddrCode(), addr.getAddrYN());
        return addr;
    }

    @Transactional
    public Addr addrUpdate(String addrCode,AddrInsertDto insertDto) {
        Addr addr = addrRepository.findById(addrCode)
                .orElseThrow(() -> new IllegalArgumentException("에러"));

        addr.update(insertDto.getAddrName(), insertDto.getAddrZip(), insertDto.getAddrBas(), insertDto.getAddrDet(), insertDto.getAddrNum(), insertDto.getAddrYN(),
                insertDto.getAddrNic());

        return addr;
    }
}
