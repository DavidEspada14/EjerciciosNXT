package com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class PersonaOutputDTO{

    private Integer id_persona;
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

    public PersonaOutputDTO(PersonaEntity personaEntity){
        setId_persona(personaEntity.getId_persona());
        setUsuario(personaEntity.getUsuario());
        setPassword(personaEntity.getPassword());
        setName(personaEntity.getName());
        setSurname(personaEntity.getSurname());
        setCompany_email(personaEntity.getCompany_email());
        setPersonal_email(personaEntity.getPersonal_email());
        setCity(personaEntity.getCity());
        setActive(personaEntity.getActive());
        setCreated_date(personaEntity.getCreated_date());
        setImagen_url(personaEntity.getImagen_url());
        setTermination_date(personaEntity.getTermination_date());
    }

    public PersonaOutputDTO(){

    }

}
