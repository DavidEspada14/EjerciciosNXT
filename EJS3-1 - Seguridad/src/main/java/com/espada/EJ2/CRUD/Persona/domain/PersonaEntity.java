package com.espada.EJ2.CRUD.Persona.domain;


import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


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
    @GenericGenerator(
            name = "persona_seq",
            strategy = "com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private Integer idPersona;

    @NotNull
    @Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    private String usuario;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Email
    private String company_email;

    @NotNull
    @Email
    private String personal_email;

    @NotNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    @NotNull
    private boolean admin;

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
        setAdmin(personaDTO.isAdmin());
    }
}
