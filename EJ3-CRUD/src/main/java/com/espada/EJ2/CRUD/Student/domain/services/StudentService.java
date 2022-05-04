package com.espada.EJ2.CRUD.Student.domain.services;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentInputDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public StudentEntity addEstudiante(StudentInputDTO estudiante) throws Exception;
    public StudentEntity findEstudianteById(String id) throws Exception;

    public void deleteById(String id) throws Exception;

    Optional<StudentEntity> findEstudianteByPersonaId(Integer id) throws Exception;

//    public Optional<ProfesorEntity> findProfesorByPersonaId(Integer IdPersona);

}
