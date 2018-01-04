package com.example.housKeeping.controller.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.housKeeping.domain.HouseKeepingItem;
import com.example.housKeeping.domain.HouseKeepingItemDto;
import com.example.housKeeping.persistance.HouseKeepingItemRepository;
import com.example.housKeeping.service.DatabaseManagement;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class MainController {

    private final HouseKeepingItemRepository houseKeepingItemRepository;

    private final DatabaseManagement databaseManagement;

    private final ConversionService converter;


    @RequestMapping("/housekeeping")
    public String getIndexPage(Model model) {
        model.addAttribute("findall", houseKeepingItemRepository.findAll());
        return "index";
    }

    @RequestMapping("/housekeeping/sum")
    public String getSum(Model model) {
        model.addAttribute("findall", houseKeepingItemRepository.sumOfValueByGroup("Rezsi"));
        model.addAttribute("sum", databaseManagement.getSums());
        model.addAttribute("allsum", databaseManagement.getSumOfAll());
        return "sum";
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
