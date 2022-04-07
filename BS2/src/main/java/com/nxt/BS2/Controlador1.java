package com.nxt.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestBody Persona persona){
        personaService.setNombre(persona.getNombre());
        personaService.setPoblacion(persona.getPoblacion());
        personaService.setEdad(persona.getEdad());

        return personaService.getPersona();
    }

    @PostMapping("/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad){
        ciudadService.setNombre(ciudad.getNombre());
        ciudadService.setNumeroHabitantes(ciudad.getNumeroHabitantes());
        ciudadService.addCiudad(ciudad);

        return ciudadService.getCiudad();
    }
}
