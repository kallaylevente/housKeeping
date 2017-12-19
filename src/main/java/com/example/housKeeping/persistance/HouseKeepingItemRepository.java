package com.example.housKeeping.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.housKeeping.domain.HouseKeepingItem;

@Repository
public interface HouseKeepingItemRepository extends JpaRepository<HouseKeepingItem, Long> {
    HouseKeepingItem findById(Long aLong);

    HouseKeepingItem findByItemType(String name);
}
