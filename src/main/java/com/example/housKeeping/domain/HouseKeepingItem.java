package com.example.housKeeping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

@Builder
@Entity
public class HouseKeepingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String itemGroup;
    public String itemType;
    public Integer valueOfItem;

    @Tolerate
    public HouseKeepingItem() {
    }

    public Long getId() {
        return id;
    }

    public String getItemGroup() {
        return itemGroup;
    }

    public String getItemType() {
        return itemType;
    }

    public Integer getValueOfItem() {
        return valueOfItem;
    }
}
