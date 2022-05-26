package com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import com.espada.EJ2.CRUD.StudentSubject.domain.services.StudentSubjectServiceImpl;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectInputDTO;
import com.espada.EJ2.CRUD.StudentSubject.infraestructure.controller.dto.StudentSubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class StudentSubjectController {

    @Autowired
    StudentSubjectServiceImpl studentSubjectService;

    @PostMapping("/addAsignatura")
    public ResponseEntity<?> addAsignatura(@RequestBody StudentSubjectInputDTO studentSubjectInputDTO) throws Exception{
        try{
            studentSubjectService.addAsignatura(studentSubjectInputDTO);
            return new ResponseEntity<>(studentSubjectInputDTO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getAsignaturaById(@PathVariable String id){
        try{
            StudentSubjectOutputDTO asignatura = new StudentSubjectOutputDTO();
            return new ResponseEntity<>(asignatura, HttpStatus.OK);
        } catch (Exception e){
            throw new NotFoundException("Asignatura con id: "+id+" no encontrada");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSubjectById(@PathVariable String id){
        try{
            studentSubjectService.deleteById(id);
        } catch (Exception e){
            return new ResponseEntity<>("Profesor con id: "+id+" no encontrado", HttpStatus.NOT_FOUND);
        }
      return new ResponseEntity<>("Profesor con id: "+id+" eliminado", HttpStatus.OK);
    }

}
