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
        PersonaEntity persona = getPersonaById(profesorInput.getPersona());
        ProfesorEntity profesor = profesorToPersona(profesorInput, persona);
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

    public PersonaEntity getPersonaById(int id) throws Exception{
        PersonaEntity persona;
        try{
            persona = personaService.findPersonaById(id);
        } catch (Exception e){
            throw new Exception("Persona con id: "+id+" no encontrada.");
        }
        return persona;
    }

    public ProfesorEntity profesorToPersona(ProfesorInputDTO profesorInputDTO, PersonaEntity persona){
        return new ProfesorEntity(
                profesorInputDTO.getId_profesor(),
                persona,
                profesorInputDTO.getComments(),
                profesorInputDTO.getBranch());
    }
}
