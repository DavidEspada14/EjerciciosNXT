package com.espada.EJ2.CRUD.Student.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentSimpleOutputDTO {

    private String id_student;
    private int num_hours_week;
    private String comments;
    private String branch;

    public StudentSimpleOutputDTO(StudentEntity studentEntity){
        if(studentEntity == null){
            return;
        }
        setId_student(studentEntity.getId_student());
        setNum_hours_week(studentEntity.getNum_hours_week());
        setComments(studentEntity.getComments());
        setBranch(studentEntity.getBranch());
    }

}
