package com.example.housKeeping.domain.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;

@Entity
@Builder
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer user_role_id;
    public String username;
    public String role;

    @ManyToOne
    HouseKeepingUser houseKeepingUseruser;
}
