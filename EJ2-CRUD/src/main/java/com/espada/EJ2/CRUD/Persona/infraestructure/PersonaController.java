package com.espada.EJ2.CRUD.Persona.infraestructure;

import com.espada.EJ2.CRUD.Persona.domain.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaRepo personaRepo;

    @PostMapping("/addPersona")
    public String addPerson(@RequestBody PersonaInputDTO persona) throws Exception{
        personaService.addPerson(persona);
        return "Persona creada correctamente: \n" + persona;
    }

}
