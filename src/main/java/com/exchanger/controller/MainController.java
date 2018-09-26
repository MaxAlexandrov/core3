package com.exchanger.controller;

import com.exchanger.model.User;
import com.exchanger.repository.RoleRepository;
import com.exchanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Получаем всех пользователей из базы и выводим Json  на экран
     * */
    @GetMapping("/all")
    public @ResponseBody
    List<User> getAllUser(){
    return userRepository.findAll();
    }

    /**
     * Отправляем логин и пароль post запросом в этот метод для проверки на существование в БД и если ОК то выводи на экран Valid
     * */
    @PostMapping("/checklogin")
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

    /**
     * Метод должен добавлять в БД нового пользователя и возвращаться на страницу /login для входа в систему*
     **/
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
}
