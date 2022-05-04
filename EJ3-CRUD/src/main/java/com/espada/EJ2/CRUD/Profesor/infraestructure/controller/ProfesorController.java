package com.espada.EJ2.CRUD.Profesor.infraestructure.controller;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Profesor.domain.services.ProfesorServiceImpl;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorFullOutputDTO;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorInputDTO;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorSimpleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl profesorService;

    @PostMapping("/addProfesor")
    public ResponseEntity<?> addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception{
        ProfesorEntity nuevoProfesor;

        try{
            nuevoProfesor = profesorService.addProfesor(profesorInputDTO);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(nuevoProfesor, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getProfesorById(@PathVariable String id, @RequestParam(defaultValue = "simple", name = "outputType") String outputType){
        try{
            ProfesorEntity profesor = profesorService.findProfesorById(id);
            if(outputType == "simple"){
                return new ResponseEntity<>(new ProfesorSimpleOutputDTO(profesor), HttpStatus.OK);
            } else if (outputType == "full"){
                return new ResponseEntity<>(new ProfesorFullOutputDTO(profesor), HttpStatus.OK);
            } else if (outputType!="simple"&&outputType!="full"){
                return new ResponseEntity<>("Valor de salida no valido", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Profesor con id: "+id+" no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Profesor con id: "+id+" no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteProfesorById(@PathVariable String id) throws Exception{
            try{
                profesorService.deleteById(id);
            } catch (Exception e){
                return new ResponseEntity<>("Profesor con id: "+id+" no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Profesor con id: "+id+" eliminado", HttpStatus.OK);
        }
}