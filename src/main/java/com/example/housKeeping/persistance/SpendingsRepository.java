package com.example.housKeeping.persistance;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.housKeeping.domain.SpendingItem;

@Repository
public interface SpendingsRepository extends JpaRepository<SpendingItem, Long> {
    SpendingItem findById(Long aLong);

    SpendingItem findByItemType(String name);

    List<SpendingItem> findByItemGroupAndMonth(String group, String month);

    @Query(value = "SELECT SUM(value_of_item) FROM spending_item WHERE item_group = ?1 AND month = ?2", nativeQuery = true)
    Integer sumOfValueByGroup(String group, String month);

}
