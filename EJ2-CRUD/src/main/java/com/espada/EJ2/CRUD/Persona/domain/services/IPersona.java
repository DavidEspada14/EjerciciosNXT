package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface IPersona {
    //List<PersonaOutputDTO> findByName(String name) throws Exception;

    PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception;
    String deleteById(Integer id) throws Exception;
    List<PersonaOutputDTO> findById (Integer id) throws Exception;
    List<PersonaOutputDTO> findByUser (String usuario) throws Exception;
    PersonaOutputDTO findByName (String name) throws Exception;
    List<PersonaEntity> findAll();

}
