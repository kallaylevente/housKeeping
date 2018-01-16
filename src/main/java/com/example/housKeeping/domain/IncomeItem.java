package com.example.housKeeping.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Builder;

@Entity
@Builder
public class IncomeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Integer valueOfIncome;
    private Timestamp timestamp;
}
