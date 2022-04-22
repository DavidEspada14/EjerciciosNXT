package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.models.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepo personaRepo;


    @Override
    public List<PersonaOutputDTO> findByName(String name) throws Exception {
        try{
            List<PersonaOutputDTO> personas = personaRepo.findByUser(name);
            return personas;
        } catch(Exception e){
            throw new Exception("El usuario no existe");
        }
    }

    @Override
    public PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception {
        if(personaDTO.getUsuario().length() < 6 || personaDTO.getUsuario().length() > 10){
            throw new Exception("El usuario debe tener entre 6 y 10 caracteres");
        } else {
            PersonaEntity personaEntity = new PersonaEntity(personaDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(personaEntity);
            return saveOutputDTO;
        }
    }

    @Override
    public String deleteById(Integer id) throws Exception {
        return null;
    }

    @Override
    public PersonaOutputDTO findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<PersonaEntity> printAll() {
        return null;
    }
}
