package com.espada.EJ2.CRUD.Persona.infraestructure;

import com.espada.EJ2.CRUD.Persona.domain.models.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

}
