package com.espada.EJ2.CRUD.Persona.infraestructure.repositories;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<PersonaEntity, Integer> {

    @Query("SELECT p FROM PersonaEntity p where p.usuario = ?1")
    public List<PersonaOutputDTO> findPersonaByUsuario(String usuario);

    @Query("SELECT p FROM PersonaEntity p")
    public List<PersonaOutputDTO> getAllPeople();
}
