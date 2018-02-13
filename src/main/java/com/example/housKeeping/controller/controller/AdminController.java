package com.example.housKeeping.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.housKeeping.service.HandleSecurityService;

@Controller
public class AdminController {


    @RequestMapping("/login")
    public String login(@RequestParam(required = false) String error) {
        return "login";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @Autowired
    HandleSecurityService handleSecurityService;

    @RequestMapping("/admin/addUser")
    public String adminPage(@RequestParam String role,
                            @RequestParam String username,
                            @RequestParam String password) {

        handleSecurityService.addNewUserAndRole(username, password, role);
        return "redirect:/housekeeping";
    }
}
