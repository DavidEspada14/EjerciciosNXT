package com.espada.EJ2.CRUD.Persona.domain;


import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaDTORecord;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public PersonaEntity(PersonaDTORecord personaDTO){
        if(personaDTO==null){
            return;
        }
        setId_persona(personaDTO.id_persona());
        setUsuario(personaDTO.usuario());
        setPassword(personaDTO.password());
        setName(personaDTO.name());
        setSurname(personaDTO.surname());
        setCompany_email(personaDTO.company_email());
        setPersonal_email(personaDTO.personal_email());
        setCity(personaDTO.city());
        setActive(personaDTO.active());
        setCreated_date(personaDTO.created_date());
        setImagen_url(personaDTO.imagen_url());
        setTermination_date(personaDTO.termination_date());
    }

}
