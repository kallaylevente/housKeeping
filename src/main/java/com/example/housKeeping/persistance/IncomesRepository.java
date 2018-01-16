package com.example.housKeeping.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.housKeeping.domain.IncomeItem;

public interface IncomesRepository extends JpaRepository<IncomeItem, Long> {

    @Query(value = "SELECT SUM(value_of_income) FROM income_item", nativeQuery = true)
    Integer getSumOfIncomes();


}
