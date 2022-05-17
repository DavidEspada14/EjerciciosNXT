package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaDTORecord;

import java.util.HashMap;
import java.util.List;

public interface IPersona {
    //List<PersonaOutputDTO> findByName(String name) throws Exception;

    PersonaDTORecord addPerson(PersonaDTORecord personaDTO) throws Exception;
    String deleteById(Integer id) throws Exception;
    PersonaDTORecord findById (Integer id) throws Exception;
    PersonaDTORecord findByName (String name) throws Exception;
    List<PersonaEntity> findAll();


    List<PersonaEntity> getData(HashMap<String, Object> conditions);
}
