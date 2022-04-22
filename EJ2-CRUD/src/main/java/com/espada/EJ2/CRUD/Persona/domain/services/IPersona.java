package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.models.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaOutputDTO;

import java.util.List;

public interface IPersona {
    List<PersonaOutputDTO> findByName(String name) throws Exception;

    PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception;
    String deleteById(Integer id) throws Exception;
    PersonaOutputDTO findById (Integer id) throws Exception;
    List<PersonaEntity> printAll();

}
