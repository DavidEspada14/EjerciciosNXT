package com.nxt.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @PostMapping("/useradd")
    public Persona postPerson(@RequestBody Persona persona){
        persona.setAge(persona.getAge()+1);
        return persona;
    }
}
