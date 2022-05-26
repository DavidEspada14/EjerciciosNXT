package com.espada.EJ2.CRUD.StudentSubject.domain.services;

import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectInputDTO;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectOutputDTO;

import java.util.List;

public interface StudentSubjectService {

    public StudentSubjectOutputDTO addAsignatura(StudentSubjectInputDTO asignatura) throws Exception;
    public StudentSubjectEntity findAsignaturaById(String id);
    public void deleteById(String id) throws Exception;

}
