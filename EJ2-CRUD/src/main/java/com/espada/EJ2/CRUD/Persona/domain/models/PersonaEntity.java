package com.espada.EJ2.CRUD.Persona.domain.models;


import com.espada.EJ2.CRUD.Persona.infraestructure.dto.PersonaInputDTO;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class PersonaEntity {

    @Id
    @GeneratedValue
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


    public PersonaEntity(){

    }

    public PersonaEntity(PersonaInputDTO personaDTO){
        if(personaDTO==null){
            return;
        }
        setId_persona(personaDTO.getId_persona());
        setUsuario(personaDTO.getUsuario());
        setPassword(personaDTO.getPassword());
        setName(personaDTO.getName());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.getActive());
        setCreated_date(personaDTO.getCreated_date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_date(personaDTO.getTermination_date());
    }




}
