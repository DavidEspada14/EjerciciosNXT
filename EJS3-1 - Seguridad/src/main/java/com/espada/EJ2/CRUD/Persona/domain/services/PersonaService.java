package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception;
    public PersonaEntity updatePerson(PersonaEntity persona, PersonaInputDTO personaInputDTO) throws Exception;
    public String deletePersonaById(Integer id) throws Exception;
    public PersonaEntity findPersonaById(int id) throws Exception;
    public List<PersonaOutputDTO> findByUser (String usuario) throws Exception;
    public List<PersonaEntity> findAll();
    public Optional<StudentEntity> findEstudianteByPersonId(Integer id);
    public Optional<ProfesorEntity> findProfesorByPersonId(Integer id);

}
