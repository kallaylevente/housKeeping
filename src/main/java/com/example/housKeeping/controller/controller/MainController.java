package com.example.housKeeping.controller.controller;


import static java.util.Optional.ofNullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.housKeeping.domain.IncomeItem;
import com.example.housKeeping.domain.IncomeItemDto;
import com.example.housKeeping.domain.SpendingItem;
import com.example.housKeeping.domain.SpendingItemDto;
import com.example.housKeeping.persistance.IncomesRepository;
import com.example.housKeeping.persistance.SpendingsRepository;
import com.example.housKeeping.service.DatabaseManagement;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class MainController {

    private final SpendingsRepository spendingsRepository;

    private final IncomesRepository incomesRepository;

    private final DatabaseManagement databaseManagement;

    private final ConversionService converter;


    @RequestMapping(value = {"/housekeeping", "*.ded"})
    public String getIndexPage(Model model) {
        model.addAttribute("findall", spendingsRepository.findAll());
        return "index";
    }
@Transactional
    @RequestMapping("/housekeeping/sum")
    public String getSum(Model model) {
        model.addAttribute("income", ofNullable(incomesRepository.getSumOfIncomes()).orElse(0));
        model.addAttribute("findall", spendingsRepository.sumOfValueByGroup("rezsi", String.valueOf(Calendar.MONTH)));
        model.addAttribute("sum", databaseManagement.getSums());
        model.addAttribute("allsum", ofNullable(databaseManagement.getSumOfAll()).orElse(0));
        return "sum";
    }

    @RequestMapping(value = "/housekeeping/addSpending", method = RequestMethod.POST)
    public String addNewSpending(Model model,
                                 @RequestParam("itemGroup") String itemGroup,
                                 @RequestParam("itemType") String itemType,
                                 @RequestParam("itemValue") String itemValue) {
        spendingsRepository.save(converter.convert(SpendingItemDto.builder()
                        .itemGroup(itemGroup)
                        .itemType(itemType)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .valueOfItem(Integer.valueOf(itemValue))
                        .build()
                , SpendingItem.class));
        return "redirect:/housekeeping";
    }

    @RequestMapping(value = "/housekeeping/addIncome", method = RequestMethod.POST)
    public String addNewIncome(Model model,
                               @RequestParam("type") String incomingtype,
                               @RequestParam("value") Integer incomingValue) {
        IncomeItem save = incomesRepository.save(converter.convert(IncomeItemDto.builder()
                .type(incomingtype)
                .valueOfIncome(incomingValue)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build(), IncomeItem.class));
        return "redirect:/housekeeping";
    }

    @RequestMapping(value = "/housekeeping/detailedSpendings/{group}", method = RequestMethod.GET)
    public String getDetailedSpendings(Model model, @PathVariable String group) {
        model.addAttribute("list", spendingsRepository.findByItemGroupAndMonth(group, String.valueOf(Calendar.MONTH)));
        return "detailed";
    }

    @RequestMapping(value = "housekeeping/delete/{id}")
    public String deleteItem(@PathVariable String id) {
        spendingsRepository.delete(Long.valueOf(id));
        return "redirect:/housekeeping/sum";
    }

    @RequestMapping("")
    public String healthCheck(Model model) {
        return "health";
    }
}
