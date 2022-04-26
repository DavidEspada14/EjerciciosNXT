package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.models.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaOutputDTO;

import java.util.List;
import java.util.Optional;

public interface IPersona {
    //List<PersonaOutputDTO> findByName(String name) throws Exception;

    PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception;
    String deleteById(Integer id) throws Exception;
    List<PersonaOutputDTO> findById (Integer id) throws Exception;
    List<PersonaOutputDTO> findByUser (String usuario) throws Exception;
    PersonaOutputDTO findByName (String name) throws Exception;
    List<PersonaEntity> findAll();

}
