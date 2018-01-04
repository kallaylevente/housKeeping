package com.example.housKeeping.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Tolerate;

@Builder
public class HouseKeepingItemDto {
    private
    String itemGroup;
    private
    String itemType;
    private
    Integer valueOfItem;

    @Tolerate
    public HouseKeepingItemDto() {
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
