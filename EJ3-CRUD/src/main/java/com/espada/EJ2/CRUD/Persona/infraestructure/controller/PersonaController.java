package com.espada.EJ2.CRUD.Persona.infraestructure.controller;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.ErrorsHandling.UnprocesableException;
import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.PersonaList;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaServiceImpl;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @PostMapping("/addPersona")
    public ResponseEntity<?> addPerson(@RequestBody PersonaInputDTO persona) throws Exception{
        try{
            personaService.addPerson(persona);
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("El usuario debe tener entre 3 y 10 caracteres");
        }

    }

    @PutMapping("/updatePersona/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody PersonaInputDTO persona) throws Exception{
        try{
            PersonaEntity personaEntity = personaService.findPersonaById(id);
            personaService.updatePerson(personaEntity, persona);
        } catch (Exception e){
            throw new UnprocesableException("No ha sido posible modificar el usuario con id: "+id);
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable Integer id) throws Exception{
        try{
            PersonaOutputDTO persona = new PersonaOutputDTO(personaService.findPersonaById(id));
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } catch (Exception e){
            throw new NotFoundException("Persona con id: "+id+" no encontrada.");
        }
    }


    @GetMapping("/getUser/{user}")
    public ResponseEntity<?> getUserName(@PathVariable String usuario) throws Exception {
        List<PersonaOutputDTO> personaOutputDTOS = new ArrayList<>();
        PersonaList personaList;
        try{
            personaService.findByUser(usuario).forEach(persona -> {
                try{
                    personaOutputDTOS.add(new PersonaOutputDTO(persona));
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
            personaList = new PersonaList(personaOutputDTOS);
        } catch (Exception e){
            return new ResponseEntity<>("Persona con usuario: " + usuario + ", no encontrada.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaList, HttpStatus.OK);
    }

    @GetMapping("/getAllPersonas")
    public ResponseEntity<?> getAllPersonas() throws Exception{
        List<PersonaOutputDTO> personaOutputDTOS = new ArrayList<>();
        PersonaList personaList;
        try{
            personaService.findAll().forEach(persona -> {
                try{
                    personaOutputDTOS.add(new PersonaOutputDTO(persona));
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
            personaList = new PersonaList(personaOutputDTOS);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personaList, HttpStatus.OK);
    }

    @DeleteMapping("/deletePersona/{id}")
    public ResponseEntity<?> deletePersonaById(@PathVariable Integer id) throws Exception {
        personaService.deletePersonaById(id);
        return new ResponseEntity<>("Persona con id: "+id+" borrada correctamente", HttpStatus.OK);
    }

}
