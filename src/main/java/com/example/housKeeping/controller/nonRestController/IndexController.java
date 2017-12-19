package com.example.housKeeping.controller.nonRestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.persistance.HouseKeepingItemRepository;

@Controller
public class IndexController {

    public static final String TABLE_ITEM_GROUP = "overhead";
    public static final String TABLE_ITEM_TYPE = "telefon";
    public static final int TABLE_ITEM_VALUE = 7000;

    @Autowired
    private HouseKeepingItemRepository houseKeepingItemRepository;

    @RequestMapping("/housekeeping/test")
    public String getIndexPage(Model model) {
        houseKeepingItemRepository.save(HouseKeepingItem.builder()
                .itemGroup(TABLE_ITEM_GROUP)
                .itemType(TABLE_ITEM_TYPE)
                .valueOfItem(TABLE_ITEM_VALUE)
                .build());
        model.addAttribute("findall", houseKeepingItemRepository.findAll());
        return "index";
    }
}
