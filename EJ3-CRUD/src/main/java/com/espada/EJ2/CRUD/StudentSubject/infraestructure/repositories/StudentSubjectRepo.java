package com.espada.EJ2.CRUD.StudentSubject.infraestructure.repositories;

import com.espada.EJ2.CRUD.StudentSubject.domain.StudentSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubjectRepo extends JpaRepository<StudentSubjectEntity, String> {
    @Query("DELETE FROM StudentSubjectEntity a where a.id = ?1")
    public void deleteById(String id);
}
