package com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorInputDTO {

    private String id_profesor;
    private int persona;
    private String comments;
    private String branch;



}
