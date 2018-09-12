package com.exchanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/user-room")
    public String beginLogin(@RequestParam(name = "login", required = false, defaultValue = "admin") String name, Model model){
        return "user-room";
    }
    @GetMapping("/regestration")
    public String getRegestration(){
        return "registration";
    }
}
