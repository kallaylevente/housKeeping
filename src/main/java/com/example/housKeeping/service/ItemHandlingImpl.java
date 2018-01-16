package com.example.housKeeping.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.housKeeping.domain.SpendingItem;
import com.example.housKeeping.domain.SpendingItemDto;

@Service
public class ItemHandlingImpl implements ItemHandling {

    @Override
    public SpendingItem createItem(SpendingItemDto dto) {
        return null;
    }

    @Override
    public SpendingItem readItemById(String houseKeepingItemId) {
        return null;
    }

    @Override
    public List<SpendingItem> readItems(String filterParam) {
        return null;
    }

    @Override
    public SpendingItem updateItem(String houseKeepingItemId, SpendingItemDto dto) {
        return null;
    }

    @Override
    public SpendingItem deleteItem(String houseKeepingItemId) {
        return null;
    }
}
