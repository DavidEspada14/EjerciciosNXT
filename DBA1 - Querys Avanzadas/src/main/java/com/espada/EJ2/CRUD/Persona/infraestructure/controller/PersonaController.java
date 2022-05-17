package com.espada.EJ2.CRUD.Persona.infraestructure.controller;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaDTORecord;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaRepo personaRepo;

    @PostMapping("/addPersona")
    public String addPerson(@RequestBody PersonaDTORecord persona) throws Exception{
        personaService.addPerson(persona);
        return "Persona creada correctamente: \n" + persona;
    }

    @GetMapping("/getId/{id}")
    public PersonaDTORecord getUserById(@PathVariable Integer id) throws Exception{
        return personaService.findById(id);
    }

    @GetMapping("/getData/user")
    public ResponseEntity<?> getDataUser(@RequestParam HashMap<String, Object> conditions){
        return ResponseEntity.ok().body(personaService.getData(conditions));
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
