package com.espada.EJ2.CRUD.Persona.infraestructure.controller;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getId/{id}")
    public List<PersonaOutputDTO> getUserById(@PathVariable Integer id) throws Exception{
        return personaService.findById(id);
    }

    @GetMapping("/getUser/{user}")
    public List<PersonaOutputDTO> getUserName(@PathVariable String usuario) throws Exception {
        return personaService.findByUser(usuario);
    }

    @GetMapping("/getAllPersonas")
    public List<PersonaEntity> getAllPersonas(){
        return personaService.findAll();
    }

    @DeleteMapping("/deletePersona/{id}")
    public String deletePersonaById(@PathVariable Integer id) throws Exception {
        personaService.deleteById(id);
        return "Persona con id: "+id+" eliminada correctamente.";
    }

}
