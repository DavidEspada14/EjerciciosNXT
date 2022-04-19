package com.nxt.RS1.controllers;

import com.nxt.RS1.User;
import com.nxt.RS1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorPOST {
    @Autowired
    UserService userService;

    @PostMapping("/user/addUser")
    public User addPersona(@RequestBody User user){
        userService.setName(user.getName());
        userService.setPass(user.getPass());
        userService.setId(user.getId());
        userService.addUser(user);

        return userService.getUser();
    }
}
