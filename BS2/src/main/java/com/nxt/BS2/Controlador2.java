package com.nxt.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {
    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersona(){
        personaService.setEdad(personaService.getEdad()+personaService.getEdad());

        return personaService.getPersona();
    }

    @GetMapping("/controlador2/getCiudad")
    public List<Ciudad> getCiudades(){

        return ciudadService.listCiudad();
    }

    @Autowired
    @Qualifier("bean1")
    Persona persona1;

    @Autowired
    @Qualifier("bean2")
    Persona persona2;

    @Autowired
    @Qualifier("bean3")
    Persona persona3;

    @GetMapping("/controlador/bean/{bean}")
    public Persona getBean(@PathVariable String bean) {
        switch(bean) {
            case "bean1" -> {
                return persona1;
            }
            case "bean2" -> {
                return persona2;
            }
            case "bean3" -> {
                return persona3;
            }
            default -> {
                return new Persona();
            }
        }

    }
}
