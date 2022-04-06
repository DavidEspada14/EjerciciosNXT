package com.nxt.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @GetMapping("/user/{name}")
    public String getHola(@PathVariable String name){
        return "Hola "+name;
    }
}
