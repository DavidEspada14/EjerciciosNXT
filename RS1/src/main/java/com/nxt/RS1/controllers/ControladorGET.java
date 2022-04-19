package com.nxt.RS1.controllers;

import com.nxt.RS1.User;
import com.nxt.RS1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorGET {
    @Autowired
    UserService userService;

    @GetMapping("/user/getUserId/{id}")
    public User getUserId(@PathVariable(value = "id") int id){
        User user = userService.getUserById(id);

        userService.setId(userService.getId());
        userService.setName(userService.getName());
        userService.setPass(userService.getPass());

        return userService.getUser();
    }

    @GetMapping("/user/getUserName/{name}")
    public User getUserName(@PathVariable String name){
        User user = userService.getUserByName(name);

        userService.setId(userService.getId());
        userService.setName(userService.getName());
        userService.setPass(userService.getPass());

        return userService.getUser();
    }
}
