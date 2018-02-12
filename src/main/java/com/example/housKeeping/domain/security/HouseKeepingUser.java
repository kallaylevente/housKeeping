package com.example.housKeeping.domain.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.experimental.Tolerate;

@Entity
@Builder
public class HouseKeepingUser {
    @Id
    public String username;
    public String password;
    public boolean enable;
    @OneToMany
    public List<UserRoles> userRoles;

    @Tolerate
    public HouseKeepingUser() {
        this.enable = true;
    }
}
