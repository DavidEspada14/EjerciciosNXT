package com.nxt.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
