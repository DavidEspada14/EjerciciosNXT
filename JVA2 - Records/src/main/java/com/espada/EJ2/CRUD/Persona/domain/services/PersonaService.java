package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaDTORecord;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public PersonaDTORecord addPerson(PersonaDTORecord personaDTO) throws Exception {
        if(personaDTO.usuario().length() < 3 || personaDTO.usuario().length() > 10){
            throw new Exception("El usuario debe tener entre 3 y 10 caracteres");
        } else {
            PersonaEntity personaEntity = new PersonaEntity(personaDTO);
            personaRepo.save(personaEntity);
            return personaDTO;
        }
    }

    @Override
    public String deleteById(Integer id) throws Exception {
        personaRepo.findById(id).orElseThrow(() -> new Exception ("Persona con id: "+id+" no encontrada."));
        personaRepo.deleteById(id);
        return "Persona con id: "+id+" eliminada correctamente.";
    }

    @Override
    public PersonaDTORecord findById(Integer id) throws Exception {
        PersonaEntity persona = personaRepo.findById(id).orElseThrow(() -> new Exception ("Persona con id: "+id+" no encontrada."));
        PersonaDTORecord personaDTO = new PersonaDTORecord(id, persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(),persona.getCompany_email(),persona.getPersonal_email(),persona.getCity(),persona.getActive(),persona.getCreated_date(),persona.getImagen_url(),persona.getTermination_date());
        return personaDTO;
    }

    @Override
    public PersonaDTORecord findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepo.findAll();
    }



}
