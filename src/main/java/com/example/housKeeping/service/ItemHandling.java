package com.example.housKeeping.service;

import java.util.List;


import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.domain.HouseKeepingItemDto;

public interface ItemHandling {
     HouseKeepingItem createItem(HouseKeepingItemDto dto);

     HouseKeepingItem readItemById(String houseKeepingItemId);

     List<HouseKeepingItem> readItems(String filterParam);

     HouseKeepingItem updateItem(String houseKeepingItemId, HouseKeepingItemDto dto);

     HouseKeepingItem deleteItem(String houseKeepingItemId);
}
