package com.espada.EJ2.CRUD.StudentSubject.domain;

import com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Estudiante_asignatura")
public class StudentSubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_asignatura_seq")
    @Column(name = "IdAsignatura")
    @GenericGenerator(
            name = "estudiante_asignatura_seq",
            strategy = "com.espada.EJ2.CRUD.SharedSequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private String id_asignatura;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEstudiante")
    private StudentEntity student;

    @Column(name = "Asignatura")
    private String asignatura;

    @Column(name = "Comentarios")
    private String comments;

    @NonNull
    @Column(name = "InitialDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date initial_date;

    @Column(name = "FinishDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finish_date;

    public StudentSubjectEntity(StudentSubjectInputDTO asignaturaDTO){
        if(asignaturaDTO==null){
            return;
        }
        setId_asignatura(asignaturaDTO.getId_asignatura());
        setAsignatura(asignaturaDTO.getAsignatura());
        setComments(asignaturaDTO.getComments());
        setInitial_date(asignaturaDTO.getInitial_date());
        setFinish_date(asignaturaDTO.getFinish_date());
    }
}
