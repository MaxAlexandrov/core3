package com.exchanger.controller;

import com.exchanger.model.User;
import com.exchanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/home")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addUsers(@RequestParam String login, @RequestParam String password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRepository.save(user);
        return "saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser(){
    return userRepository.findAll();
    }
    @GetMapping(path = "/checklogin")
    public @ResponseBody String checker(@RequestParam String login, @RequestParam String password ){
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
             if(login!=null&&password!=null){
                if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
                    return "Valid";
                }
             }
        }
        return "Not valid, please go to registration page";
    }
}
