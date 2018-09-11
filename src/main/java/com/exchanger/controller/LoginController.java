package com.exchanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/regestration")
    public String getRegestration(){
        return "registration";
    }
}
