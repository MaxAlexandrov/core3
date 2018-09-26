package com.exchanger.controller;

import com.exchanger.model.Message;
import com.exchanger.model.User;
import com.exchanger.repository.MessageRepository;
import com.exchanger.repository.MessageTypeRepository;
import com.exchanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class PrivateAreaController {

    private User user;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageTypeRepository messageTypeRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String getUserRoomPage(User user){
        this.user = userRepository.findByLogin(user.getLogin());
        return "user-room";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        List<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findAll();
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("all_message", messages);
        return "user-room";
    }

    @PostMapping("send")
    public String send(@RequestParam String email,@RequestParam String textMessage, @RequestParam String typeM , Model model) {
       if(!email.isEmpty()&&!textMessage.isEmpty()&&!typeM.isEmpty()) {
           Message message = new Message();
           message.setText_message(textMessage);
           message.setMessage_type(messageTypeRepository.findByType(typeM).getId());
           message.setUser_to(userRepository.findByEmail(email).getId());
           message.setUser_from(userRepository.findByEmail("admin@mail.ru").getId());
           message.setDateSend(new Date());
           messageRepository.save(message);
       }
        model.addAttribute("success", "Done");
        return "user-room";
    }
}
