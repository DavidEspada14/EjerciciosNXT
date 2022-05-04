package com.espada.EJ2.CRUD.StudentSubject.domain.services;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectInputDTO;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectOutputDTO;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.repositories.StudentSubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService{

    @Autowired
    private StudentSubjectRepo studentSubjectRepo;

    @Override
    public StudentSubjectOutputDTO addAsignatura(StudentSubjectInputDTO inputAsignatura) throws Exception {
        StudentSubjectEntity asignatura = new StudentSubjectEntity(inputAsignatura);
        studentSubjectRepo.save(asignatura);
        StudentSubjectOutputDTO saveOutputDTO = new StudentSubjectOutputDTO(asignatura);
        return saveOutputDTO;
    }

    @Override
    public StudentSubjectEntity findAsignaturaById(String id) {
        return studentSubjectRepo.findById(id).orElseThrow(() -> new NotFoundException("Asignatura con id: "+id+" no encontrada"));
    }

    @Override
    public void deleteById(String id) throws Exception {
        studentSubjectRepo.deleteById(id);
    }


}
