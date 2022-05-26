package com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaFullOutputDTO {

    private Integer idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    private StudentEntity estudiante;
    private ProfesorEntity profesor;

    public PersonaFullOutputDTO(PersonaEntity persona){
        if (persona == null) return;
        setIdPersona(persona.getIdPersona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());

    }
}
