package com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorFullOutputDTO {

    private String id_profesor;
    private String comments;
    private String branch;
    private PersonaEntity persona;

    public ProfesorFullOutputDTO(ProfesorEntity profesor){
        if(profesor==null){
            return;
        }
        setId_profesor(profesor.getId_profesor());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
        setPersona(profesor.getPersona());
    }

}
