package com.example.housKeeping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.housKeeping.domain.security.HouseKeepingUser;
import com.example.housKeeping.domain.security.UserRoles;
import com.example.housKeeping.persistance.UserRepository;
import com.example.housKeeping.persistance.UserRolesRepository;

@Service
public class HandleSecurityService {
    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void addNewUserAndRole(String username, String password, String role) {
        userRepository.save(HouseKeepingUser.builder().username(username).password(passwordEncoder.encode(password)).enable(true).build());
        userRolesRepository.save(UserRoles.builder().username(username).role(role).build());
    }
}
