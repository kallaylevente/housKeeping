package com.example.housKeeping.domain;

import org.springframework.beans.factory.annotation.Required;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HouseKeepingItemDto {
    public String itemName;
    public String itemType;
    public Integer valueOfItem;
}
