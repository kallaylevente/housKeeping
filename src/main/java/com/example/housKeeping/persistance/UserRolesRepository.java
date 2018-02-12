package com.example.housKeeping.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.housKeeping.domain.security.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>{

}
