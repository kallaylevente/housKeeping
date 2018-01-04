package com.example.housKeeping.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.housKeeping.domain.HouseKeepingItem;

@Repository
public interface HouseKeepingItemRepository extends JpaRepository<HouseKeepingItem, Long> {
    HouseKeepingItem findById(Long aLong);

    HouseKeepingItem findByItemType(String name);

    @Query(value = "SELECT SUM(value_of_item) FROM house_keeping_item WHERE item_group = ?1", nativeQuery = true)
    Integer sumOfValueByGroup(String group);
}
