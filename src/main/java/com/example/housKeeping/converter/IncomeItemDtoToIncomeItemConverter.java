package com.example.housKeeping.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.housKeeping.domain.IncomeItem;
import com.example.housKeeping.domain.IncomeItemDto;

public class IncomeItemDtoToIncomeItemConverter implements Converter<IncomeItemDto, IncomeItem> {
    @Override
    public IncomeItem convert(IncomeItemDto source) {
        return IncomeItem.builder()
                .type(source.getType())
                .valueOfIncome(source.getValueOfIncome())
                .timestamp(source.getTimestamp())
                .build();
    }
}
