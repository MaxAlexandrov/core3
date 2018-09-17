package com.exchanger.controller;

import com.exchanger.model.User;
import com.exchanger.repository.RoleRepository;
import com.exchanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleReepository;

    @GetMapping ("/registration")
    public String getRegistrationPage(){
        return "registration";
    }

    @PostMapping("/registration")
    public String setRegistration(User user, Model model) {
        User userFromDB = userRepository.findBylogin(user.getLogin());
        if(userFromDB!=null){
            model.addAttribute("message", "This login exist in System");
            return "registration";
        }
        userRepository.save(user);
        return "redirect:/login";
    }
}
