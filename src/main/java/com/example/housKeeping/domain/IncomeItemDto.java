package com.example.housKeeping.domain;

import java.sql.Timestamp;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IncomeItemDto {
    private String type;
    private Integer valueOfIncome;
    private Timestamp timestamp;
}
