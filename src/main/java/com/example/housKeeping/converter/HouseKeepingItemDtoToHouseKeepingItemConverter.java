package com.example.housKeeping.converter;


import org.springframework.core.convert.converter.Converter;

import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.domain.HouseKeepingItemDto;

public class HouseKeepingItemDtoToHouseKeepingItemConverter implements Converter<HouseKeepingItemDto, HouseKeepingItem> {
    @Override
    public HouseKeepingItem convert(HouseKeepingItemDto source) {
        return HouseKeepingItem.builder()
                .itemGroup(source.getItemGroup())
                .itemType(source.getItemType())
                .valueOfItem(source.getValueOfItem())
                .build();
    }
}
