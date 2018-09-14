package com.exchanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("/user-room")
    public String getUserRoom(){
        return "user-room";
    }

    @RequestMapping (path = "/registration", method = RequestMethod.GET)
    public String getRegestrationPage(){
        return "registration";
    }
}
