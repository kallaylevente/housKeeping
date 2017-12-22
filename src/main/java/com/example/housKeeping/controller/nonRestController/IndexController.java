package com.example.housKeeping.controller.nonRestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.domain.HouseKeepingItemDto;
import com.example.housKeeping.persistance.HouseKeepingItemRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class IndexController {

    public static final String TABLE_ITEM_GROUP = "overhead";
    public static final String TABLE_ITEM_TYPE = "telefon";
    public static final int TABLE_ITEM_VALUE = 7000;

    private final HouseKeepingItemRepository houseKeepingItemRepository;

    private final ConversionService converter;



    @RequestMapping("/housekeeping")

    public String getIndexPage(Model model) {
        houseKeepingItemRepository.save(HouseKeepingItem.builder()
                .itemGroup(TABLE_ITEM_GROUP)
                .itemType(TABLE_ITEM_TYPE)
                .valueOfItem(TABLE_ITEM_VALUE)
                .build());
        model.addAttribute("findall", houseKeepingItemRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/housekeeping/addItem", method = RequestMethod.POST)
    public String addNewItem(Model model,
                             @RequestParam("itemGroup") String itemGroup,
                             @RequestParam("itemType") String itemType,
                             @RequestParam("itemValue") String itemValue) {
        houseKeepingItemRepository.save(converter.convert(HouseKeepingItemDto.builder()
                .itemGroup(itemGroup)
                .itemType(itemType)
                .valueOfItem(Integer.valueOf(itemValue))
                .build()
                , HouseKeepingItem.class));
        return "redirect:/housekeeping";
    }

    @RequestMapping("")
    public String healthCheck(Model model) {
        return "health";
    }
}
