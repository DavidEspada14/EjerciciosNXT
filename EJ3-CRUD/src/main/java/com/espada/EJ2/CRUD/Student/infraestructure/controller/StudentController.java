package com.espada.EJ2.CRUD.Student.infraestructure.controller;

import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.Student.domain.services.StudentServiceImpl;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentFullOutputDTO;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentInputDTO;
import com.espada.EJ2.CRUD.Student.infraestructure.controller.dto.StudentSimpleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiante")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/addEstudiante")
    public ResponseEntity<?> addEstudiante(@RequestBody StudentInputDTO studentInputDTO) throws Exception{
        StudentEntity nuevoEstudiante;

        try{
            nuevoEstudiante = studentService.addEstudiante(studentInputDTO);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id, @RequestParam(defaultValue = "simple", name = "outputType") String outputType){
        try{
            StudentEntity estudiante = studentService.findEstudianteById(id);

            if(outputType == "simple"){
                return new ResponseEntity<>(new StudentSimpleOutputDTO(estudiante), HttpStatus.OK);
            } else if (outputType == "full"){
                return new ResponseEntity<>(new StudentFullOutputDTO(estudiante), HttpStatus.OK);
            } else if (outputType!="simple"&&outputType!="full"){
                return new ResponseEntity<>("Valor de salida no valido", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e){
            return new ResponseEntity<>("Estudiante con id: "+id+" no encontrado", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Estudiante con id: "+id+" no encontrado", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable String id){
        try{
            studentService.deleteById(id);
        } catch (Exception e){
            return new ResponseEntity<>("Estudiante con id: "+id+" no encontrado", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Estudiante con id: "+id+" eliminado", HttpStatus.OK);
    }

}
