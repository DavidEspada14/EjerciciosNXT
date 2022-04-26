package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepo personaRepo;


    /*@Override
    public List<PersonaOutputDTO> findByName(String name) throws Exception {
        try{
            List<PersonaOutputDTO> personas = personaRepo.findByUser(name);
            return personas;
        } catch(Exception e){
            throw new Exception("El usuario no existe");
        }
    }*/

    @Override
    public PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception {
        if(personaDTO.getUsuario().length() < 3 || personaDTO.getUsuario().length() > 10){
            throw new Exception("El usuario debe tener entre 3 y 10 caracteres");
        } else {
            PersonaEntity personaEntity = new PersonaEntity(personaDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(personaEntity);
            return saveOutputDTO;
        }
    }

    @Override
    public String deleteById(Integer id) throws Exception {
        personaRepo.findById(id).orElseThrow(() -> new Exception ("Persona con id: "+id+" no encontrada."));
        personaRepo.deleteById(id);
        return "Persona con id: "+id+" eliminada correctamente.";
    }

    @Override
    public List<PersonaOutputDTO> findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<PersonaOutputDTO> findByUser(String usuario) throws Exception {
        try{
            List<PersonaOutputDTO> byUserEntity ;//= personaRepo.findByUser(usuario);
            return null;
        } catch (Exception e){
            throw new Exception("No se ha podido encontrar el usuario");
        }
    }

    @Override
    public PersonaOutputDTO findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepo.findAll();
    }



}
