package com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import lombok.Data;

import java.util.Date;

@Data
public class StudentSubjectOutputDTO {

    private String id_asignatura;
    private StudentEntity student;
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public StudentSubjectOutputDTO(StudentSubjectEntity studentSubjectEntity){
        setId_asignatura(studentSubjectEntity.getId_asignatura());
        setStudent(studentSubjectEntity.getStudent());
        setAsignatura(studentSubjectEntity.getAsignatura());
        setComments(studentSubjectEntity.getComments());
        setInitial_date(studentSubjectEntity.getInitial_date());
        setFinish_date(studentSubjectEntity.getFinish_date());
    }

    public StudentSubjectOutputDTO(){

    }

}
