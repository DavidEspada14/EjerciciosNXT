package com.nxt.RS1.controllers;

import com.nxt.RS1.User;
import com.nxt.RS1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDELETE {
    @Autowired
    UserService userService;

    @DeleteMapping("/user/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        User user = userService.getUserById(id);
        userService.removeUser(user);

        return "Persona con id " + user.getId() + " y nombre " + user.getName() + " eliminado";
    }

}
