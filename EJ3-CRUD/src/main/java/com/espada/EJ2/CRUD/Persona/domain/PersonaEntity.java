package com.espada.EJ2.CRUD.Persona.domain;


import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "Persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPersona")
    private Integer idPersona;

    @NotNull
    @Column(name = "User")
    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    private String usuario;

    @NotNull
    @Column(name = "Password")
    private String password;

    @NotNull
    @Column(name = "Name")
    private String name;

    @NotNull
    @Column(name = "Surname")
    private String surname;

    @NotNull
    @Email
    @Column(name = "CompanyEmail")
    private String company_email;

    @NotNull
    @Email
    @Column(name = "PersonalEmail")
    private String personal_email;

    @NotNull
    @Column(name = "City")
    private String city;

    @NotNull
    @Column(name = "Active")
    private Boolean active;

    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;

    @Column(name = "ImagenURL")
    private String imagen_url;

    @Column(name = "TerminationDate")
    private Date termination_date;

    public PersonaEntity(){
    }

    public PersonaEntity(PersonaInputDTO personaDTO){
        if(personaDTO==null){
            return;
        }
        setIdPersona(personaDTO.getIdPersona());
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
