package com.espada.EJ2.CRUD.Profesor.domain;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorInputDTO;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Profesor")
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdProfesor")
    private String id_profesor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPersona")
    private PersonaEntity persona;

    @Column(name = "Comentarios")
    private String comments;

    @NonNull
    @Column(name = "Rama")
    private String branch;

    public ProfesorEntity(){
    }

    public ProfesorEntity(ProfesorInputDTO profesorDTO){
        if(profesorDTO==null){
            return;
        }
        setId_profesor(profesorDTO.getId_profesor());
        setPersona(profesorDTO.getPersona());
        setComments(profesorDTO.getComments());
        setBranch(profesorDTO.getBranch());
    }
}
