package com.exchanger.controller;

import com.exchanger.model.User;
import com.exchanger.repository.UserRepository;
import com.exchanger.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/user-room")
    public String getUserRoomPage(){
        return "user-room";
    }

//    @PostMapping("/add")
//    public  String addUsers(User user, Model model){
//        if(userRepository.findBylogin(user.getLogin())!=null){
//            model.addAttribute("message","This user already exist in system!");
//            return "registration";
//        }
//        userRepository.save(user);
//        model.addAttribute("user",user);
//        return "redirect:/login";
//    }
    @GetMapping("/all")
    public @ResponseBody
    List<User> getAllUser(){
    return userRepository.findAll();
    }

    @PostMapping(path = "/checklogin")
    public @ResponseBody String checker(@RequestParam String login, @RequestParam String password){
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
             if(login!=null&&password!=null){
                if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
                    return "Valid";
                }
             }
        }
        return "Not Valid";
    }
}
