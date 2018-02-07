package com.example.housKeeping.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Builder;
import lombok.experimental.Tolerate;

@Builder
@Entity
public class SpendingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String itemGroup;
    public String itemType;
    public Integer valueOfItem;
    public Timestamp timestamp;
    public String month;


    @Tolerate
    public SpendingItem() {
    }

}
