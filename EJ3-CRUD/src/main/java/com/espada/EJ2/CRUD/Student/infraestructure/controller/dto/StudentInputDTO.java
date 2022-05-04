package com.espada.EJ2.CRUD.Student.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO {

    private String id_student;
    private int persona;
    private String idProfesor;
    private String comments;
    private Integer num_hours_week;
    private String branch;
    private Set<StudentSubjectEntity> asignaturas;




}
