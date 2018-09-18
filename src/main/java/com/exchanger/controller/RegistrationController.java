package com.exchanger.controller;

import com.exchanger.model.User;
import com.exchanger.repository.RoleRepository;
import com.exchanger.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("registration")
public class RegistrationController {
    Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleReepository;

    @GetMapping
    public String getRegistrationPage(){
        return "registration";
    }

    @PostMapping("add")
    public String add(@ModelAttribute User user, Model model){
//        User userFromDB = userRepository.findBylogin(login);
//        if(userFromDB!=null){
//            model.addAttribute("message", "This login exist in System");
//            return "registration";
//        }
        logger.info("A INFO Зашли в POST Mapping/");
        userRepository.save(user);
        return "redirect:/";
    }
}
