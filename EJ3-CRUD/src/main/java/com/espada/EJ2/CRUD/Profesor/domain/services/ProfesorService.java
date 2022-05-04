package com.espada.EJ2.CRUD.Profesor.domain.services;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorInputDTO;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {

    public ProfesorEntity addProfesor(ProfesorInputDTO profesor) throws Exception;
    public ProfesorEntity findProfesorById(String id) throws Exception;

    public void deleteById(String id) throws Exception;

    Optional<ProfesorEntity> findProfesorByPersonaId(Integer id) throws Exception;

    public List<ProfesorEntity> listaProfesores();
}
