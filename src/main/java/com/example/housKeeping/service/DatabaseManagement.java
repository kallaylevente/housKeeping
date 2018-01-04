package com.example.housKeeping.service;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.housKeeping.persistance.HouseKeepingItemRepository;
import static java.util.Optional.ofNullable;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DatabaseManagement {

    private final HouseKeepingItemRepository houseKeepingItemRepository;

    public Map<String, Integer> getSums() {
        return createSumHashMap();
    }

    public Integer getSumOfAll() {
        return createSumHashMap().entrySet().stream().mapToInt(Map.Entry::getValue).sum();
    }

    private Map<String, Integer> createSumHashMap() {
        Map<String, Integer> sumMap = new HashMap<>();
        sumMap.put("Rezsi", ofNullable(houseKeepingItemRepository.sumOfValueByGroup("Rezsi")).orElse(0));
        sumMap.put("Household", ofNullable(houseKeepingItemRepository.sumOfValueByGroup("Household")).orElse(0));
        sumMap.put("Shopping", ofNullable(houseKeepingItemRepository.sumOfValueByGroup("Shopping")).orElse(0));
        sumMap.put("Habzsi", ofNullable(houseKeepingItemRepository.sumOfValueByGroup("Habzsi")).orElse(0));
        return sumMap;
    }
}
