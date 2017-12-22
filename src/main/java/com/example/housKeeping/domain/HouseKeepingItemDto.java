package com.example.housKeeping.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HouseKeepingItemDto {
    private
    String itemGroup;
    private
    String itemType;
    private
    Integer valueOfItem;
}
