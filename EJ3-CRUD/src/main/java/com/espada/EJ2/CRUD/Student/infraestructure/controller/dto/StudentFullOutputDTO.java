package com.espada.EJ2.CRUD.Student.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentFullOutputDTO {

    private String id_student;
    private String comments;
    private Integer num_hours_week;
    private String branch;
    private PersonaEntity persona;

    public StudentFullOutputDTO(StudentEntity estudiante){
        if(estudiante == null){
            return;
        }
        setId_student(estudiante.getId_student());
        setComments(estudiante.getComments());
        setNum_hours_week(estudiante.getNum_hours_week());
        setBranch(estudiante.getBranch());
        setPersona(estudiante.getPersona());
    }
}
