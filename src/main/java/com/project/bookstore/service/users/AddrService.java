package com.project.bookstore.service.users;

import com.project.bookstore.domain.addr.AddrRepository;
import com.project.bookstore.web.user.dto.addrDto.AddrInsertDto;
import com.project.bookstore.web.user.dto.addrDto.AddrListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddrService {

    private final AddrRepository addrRepository;

    // 주소 등록
    @Transactional
    public Long addrSave(AddrInsertDto insertDto) {
        return addrRepository.save(insertDto.toEntity()).getAddrZip();
    }

    // 주소 조회
    @Transactional
    public List<AddrListDto> findAddr(String usersID) {
        return addrRepository.findAll(usersID).stream()
                .map(AddrListDto::new)
                .collect(Collectors.toList());
    }

    // 기본 배송지 변경
    @Transactional
    public void addrUpdateYN(String usersid) {
        addrRepository.updateAddrYN(usersid);
    }
}
