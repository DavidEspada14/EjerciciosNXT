package com.espada.EJ2.CRUD.Profesor.infraestructure.repositories;

import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepo extends JpaRepository<ProfesorEntity, String> {
    @Query("SELECT p FROM ProfesorEntity p where p.persona.id like ?1")
    public Optional<ProfesorEntity> findProfesorByPersonaID(Integer id);

    @Query("DELETE FROM ProfesorEntity p WHERE p.id = ?1")
    public void deleteById(String id);
}
