package com.example.housKeeping.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.domain.HouseKeepingItemDto;

@Service
public class ItemHandlingImpl implements ItemHandling {

    @Override
    public HouseKeepingItem createItem(HouseKeepingItemDto dto) {
        return null;
    }

    @Override
    public HouseKeepingItem readItemById(String houseKeepingItemId) {
        return null;
    }

    @Override
    public List<HouseKeepingItem> readItems(String filterParam) {
        return null;
    }

    @Override
    public HouseKeepingItem updateItem(String houseKeepingItemId, HouseKeepingItemDto dto) {
        return null;
    }

    @Override
    public HouseKeepingItem deleteItem(String houseKeepingItemId) {
        return null;
    }
}
