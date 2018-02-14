package com.example.housKeeping.config;


import static java.lang.System.getenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.housKeeping.domain.security.HouseKeepingUser;
import com.example.housKeeping.domain.security.UserRoles;
import com.example.housKeeping.persistance.UserRepository;
import com.example.housKeeping.persistance.UserRolesRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StartupConfig implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRolesRepository userRolesRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        userRepository.save(HouseKeepingUser.builder().username(getenv("LOGIN_USERNAME")).password(passwordEncoder.encode(getenv("LOGIN_PASSWORD"))).enable(true).build());
        userRolesRepository.save(UserRoles.builder().username(getenv("LOGIN_USERNAME")).role("ADMIN").build());
    }
}
