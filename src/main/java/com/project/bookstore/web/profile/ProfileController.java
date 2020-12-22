package com.project.bookstore.web.profile;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        // env.getActiveProfiles() : 실행 중인 ActiveProfile을 모두 가져옴 > real, real-db 등이 활성화되어있다면 2개가 담겨옴
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProile = profiles.isEmpty()?"default":profiles.get(0);

        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProile);
    }
}
