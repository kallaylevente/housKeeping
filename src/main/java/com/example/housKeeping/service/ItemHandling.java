package com.example.housKeeping.service;

import java.util.List;


import com.example.housKeeping.domain.SpendingItem;
import com.example.housKeeping.domain.SpendingItemDto;

public interface ItemHandling {
     SpendingItem createItem(SpendingItemDto dto);

     SpendingItem readItemById(String houseKeepingItemId);

     List<SpendingItem> readItems(String filterParam);

     SpendingItem updateItem(String houseKeepingItemId, SpendingItemDto dto);

     SpendingItem deleteItem(String houseKeepingItemId);
}
