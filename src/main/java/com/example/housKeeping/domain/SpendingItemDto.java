package com.example.housKeeping.domain;

import java.sql.Timestamp;


import lombok.Builder;
import lombok.experimental.Tolerate;

@Builder
public class SpendingItemDto {
    private
    String itemGroup;
    private
    String itemType;
    private
    Integer valueOfItem;
    private Timestamp timestamp;

    @Tolerate
    public SpendingItemDto() {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
