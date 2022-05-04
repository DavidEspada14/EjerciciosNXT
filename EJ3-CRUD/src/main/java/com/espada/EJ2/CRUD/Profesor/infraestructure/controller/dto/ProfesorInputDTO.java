package com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import lombok.Data;

@Data
public class ProfesorInputDTO {

    private String id_profesor;
    private String comments;
    private String branch;

    private PersonaEntity persona;

    public ProfesorInputDTO(ProfesorEntity profesorEntity){
        setId_profesor(profesorEntity.getId_profesor());
        setComments(profesorEntity.getComments());
        setBranch(profesorEntity.getBranch());
        setPersona(profesorEntity.getPersona());
    }

    public ProfesorInputDTO(){

    }
}
