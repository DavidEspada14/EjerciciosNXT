package com.espada.EJ2.CRUD.Persona.domain;

import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonaList {
    List<PersonaOutputDTO> listaPersonas;

    public PersonaList(List<PersonaOutputDTO> listaPersonas){
        this.listaPersonas = listaPersonas;
    }
}
