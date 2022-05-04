package com.espada.EJ2.CRUD.Persona.domain;

import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonaList {
    List<PersonaOutputDTO> listaPersonas;

    public PersonaList(List<PersonaOutputDTO> listaPersonas){
        this.listaPersonas = listaPersonas;
    }
}
