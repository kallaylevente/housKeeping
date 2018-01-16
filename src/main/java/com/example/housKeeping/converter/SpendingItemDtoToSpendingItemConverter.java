package com.example.housKeeping.converter;


import org.springframework.core.convert.converter.Converter;

import com.example.housKeeping.domain.SpendingItem;
import com.example.housKeeping.domain.SpendingItemDto;

public class SpendingItemDtoToSpendingItemConverter implements Converter<SpendingItemDto, SpendingItem> {
    @Override
    public SpendingItem convert(SpendingItemDto source) {
        return SpendingItem.builder()
                .itemGroup(source.getItemGroup())
                .itemType(source.getItemType())
                .valueOfItem(source.getValueOfItem())
                .timestamp(source.getTimestamp())
                .build();
    }
}
