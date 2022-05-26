package com.espada.EJ2.CRUD.Student.infraestructure.repositories;

import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, String> {
    @Query("SELECT e FROM StudentEntity e where e.persona.id = ?1")
    public Optional<StudentEntity> findStudentByPersonaID(Integer id);

    @Query("DELETE FROM StudentEntity e where e.id = ?1")
    public void deleteById(String id);

}
