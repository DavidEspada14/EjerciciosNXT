package com.espada.EJ2.CRUD.Student.domain;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentInputDTO;
import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estudiante")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq")
    @Column(name = "IdEstudiante")
    @GenericGenerator(
            name = "estudiante_seq",
            strategy = "com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private String id_student;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPersona")
    @JsonBackReference
    private PersonaEntity persona;

    @Column(name = "HorasPorSemana")
    private int num_hours_week;

    @Column(name = "Comentarios")
    private String comments;

    @Column(name = "Rama")
    private String branch;


//    public StudentEntity(StudentInputDTO inputDTO){
//        if(inputDTO==null){
//            return;
//        }
//        setId_student(inputDTO.getId_student());
//        setNum_hours_week(inputDTO.getNum_hours_week());
//        setComments(inputDTO.getComments());
//        setBranch(inputDTO.getBranch());
//    }

}
