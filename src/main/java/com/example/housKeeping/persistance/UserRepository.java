package com.example.housKeeping.persistance;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.housKeeping.domain.security.HouseKeepingUser;

@Repository
public interface UserRepository extends JpaRepository<HouseKeepingUser, String>{

  /*  @Transactional
    @Query(nativeQuery = true, value =
            "INSERT INTO house_keeping_user (username, password, enable) " +
                    "VALUES (kallaylevente, password, true)")
    @Modifying
    void insertUser();*/
}
