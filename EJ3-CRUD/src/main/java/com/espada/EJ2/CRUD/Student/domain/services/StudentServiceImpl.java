package com.espada.EJ2.CRUD.Student.domain.services;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Profesor.domain.services.ProfesorService;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentInputDTO;
import com.espada.EJ2.CRUD.Student.infraestructure.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProfesorService profesorService;


    @Override
    public StudentEntity addEstudiante(StudentInputDTO estudianteInputDTO) throws Exception {
        PersonaEntity persona = getPersonaById(estudianteInputDTO.getPersona());
        StudentEntity estudiante =studentToPersona(estudianteInputDTO, persona);
        studentRepo.save(estudiante);
        return estudiante;
    }

    @Override
    public StudentEntity findEstudianteById(String id) throws Exception {
        return studentRepo.findById(id).orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+" no encontrado"));
    }

    @Override
    public void deleteById(String id) throws Exception {
        studentRepo.deleteById(id);
    }

    @Override
    public Optional<StudentEntity> findEstudianteByPersonaId(Integer id) throws Exception {
        return studentRepo.findStudentByPersonaID(id);
    }


    public PersonaEntity getPersonaById(int id) throws Exception{
        PersonaEntity persona;
        try{
            persona = personaService.findPersonaById(id);
        } catch (Exception e){
            throw new Exception("Persona con id: "+id+" no encontrada.");
        }
        return persona;
    }

    public StudentEntity studentToPersona(StudentInputDTO estudianteInputDTO, PersonaEntity persona) {
        return new StudentEntity(
                estudianteInputDTO.getId_student(),
                persona,
                estudianteInputDTO.getNum_hours_week(),
                estudianteInputDTO.getComments(),
                estudianteInputDTO.getBranch());
    }
}
