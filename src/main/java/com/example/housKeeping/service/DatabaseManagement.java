package com.example.housKeeping.service;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.housKeeping.persistance.SpendingsRepository;
import static java.util.Optional.ofNullable;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DatabaseManagement {

    private final SpendingsRepository spendingsRepository;

    public Map<String, Integer> getSums() {
        return createSumHashMap();
    }

    public Integer getSumOfAll() {
        return createSumHashMap().entrySet().stream().mapToInt(Map.Entry::getValue).sum();
    }

    private Map<String, Integer> createSumHashMap() {
        Map<String, Integer> sumMap = new HashMap<>();
        sumMap.put("rezsi", ofNullable(spendingsRepository.sumOfValueByGroup("rezsi")).orElse(0));
        sumMap.put("household", ofNullable(spendingsRepository.sumOfValueByGroup("household")).orElse(0));
        sumMap.put("shopping", ofNullable(spendingsRepository.sumOfValueByGroup("shopping")).orElse(0));
        sumMap.put("fun", ofNullable(spendingsRepository.sumOfValueByGroup("fun")).orElse(0));
        return sumMap;
    }
}
