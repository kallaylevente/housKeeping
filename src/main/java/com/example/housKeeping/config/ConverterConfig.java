package com.example.housKeeping.config;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;

import com.example.housKeeping.converter.HouseKeepingItemDtoToHouseKeepingItemConverter;

@Configuration
public class ConverterConfig {
    @Autowired
    private ConfigurableConversionService mvcConversionService;

    @PostConstruct
    public void initializeConversionService() {
        mvcConversionService.addConverter(new HouseKeepingItemDtoToHouseKeepingItemConverter());
    }
}
