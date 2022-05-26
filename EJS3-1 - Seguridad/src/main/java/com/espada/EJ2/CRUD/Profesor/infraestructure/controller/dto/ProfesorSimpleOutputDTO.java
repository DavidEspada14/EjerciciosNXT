package com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorSimpleOutputDTO {

    private String id_profesor;
    private String comments;
    private String branch;

    public ProfesorSimpleOutputDTO(ProfesorEntity profesorEntity){
        setId_profesor(profesorEntity.getId_profesor());
        setComments(profesorEntity.getComments());
        setBranch(profesorEntity.getBranch());
    }
}
