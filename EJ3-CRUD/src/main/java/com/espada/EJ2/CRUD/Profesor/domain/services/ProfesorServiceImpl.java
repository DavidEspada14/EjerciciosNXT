package com.espada.EJ2.CRUD.Profesor.domain.services;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.domain.services.PersonaService;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Profesor.infraestructure.controller.dto.ProfesorInputDTO;
import com.espada.EJ2.CRUD.Profesor.infraestructure.repositories.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepo profesorRepo;

    @Autowired
    private PersonaService personaService;

    @Override
    public ProfesorEntity addProfesor(ProfesorInputDTO profesorInput) throws Exception {
        ProfesorEntity profesor = new ProfesorEntity(profesorInput);
        profesorRepo.save(profesor);
        return profesor;
    }

    @Override
    public ProfesorEntity findProfesorById(String id) throws Exception {
        return profesorRepo.findById(id).orElseThrow(()-> new NotFoundException("Profesor con id: "+id+" no encontrado"));
    }

    @Override
    public void deleteById(String id) throws Exception {
        profesorRepo.deleteById(id);
    }

    @Override
    public Optional<ProfesorEntity> findProfesorByPersonaId(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<ProfesorEntity> listaProfesores() {
        return null;
    }
}
