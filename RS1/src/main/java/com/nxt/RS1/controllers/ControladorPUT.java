package com.nxt.RS1.controllers;

import com.nxt.RS1.User;
import com.nxt.RS1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPUT {
    @Autowired
    UserService userService;

    @PutMapping("/user/putUser")
    public User putUser(@RequestBody User user){
        userService.setName(user.getName());
        userService.setPass(user.getPass());
        userService.setId(user.getId());

        userService.addUser(user);

        return userService.getUser();
    }



}
