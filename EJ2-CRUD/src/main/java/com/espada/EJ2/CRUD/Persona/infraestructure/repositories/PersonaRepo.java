package com.espada.EJ2.CRUD.Persona.infraestructure.repositories;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<PersonaEntity, Integer> {
}
