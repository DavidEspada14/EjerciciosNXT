package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaDTORecord;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public PersonaDTORecord addPerson(PersonaDTORecord personaDTO) throws Exception {
        if(personaDTO.usuario().length() < 3 || personaDTO.usuario().length() > 10){
            throw new Exception("El usuario debe tener entre 3 y 10 caracteres");
        } else {
            PersonaEntity personaEntity = new PersonaEntity(personaDTO);
            personaRepo.save(personaEntity);
            return personaDTO;
        }
    }

    @Override
    public String deleteById(Integer id) throws Exception {
        personaRepo.findById(id).orElseThrow(() -> new Exception ("Persona con id: "+id+" no encontrada."));
        personaRepo.deleteById(id);
        return "Persona con id: "+id+" eliminada correctamente.";
    }

    @Override
    public PersonaDTORecord findById(Integer id) throws Exception {
        PersonaEntity persona = personaRepo.findById(id).orElseThrow(() -> new Exception ("Persona con id: "+id+" no encontrada."));
        PersonaDTORecord personaDTO = new PersonaDTORecord(id, persona.getUsuario(), persona.getPassword(), persona.getName(), persona.getSurname(),persona.getCompany_email(),persona.getPersonal_email(),persona.getCity(),persona.getActive(),persona.getCreated_date(),persona.getImagen_url(),persona.getTermination_date());
        return personaDTO;
    }

    @Override
    public PersonaDTORecord findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepo.findAll();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PersonaEntity> getData(HashMap<String, Object> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntity> query = cb.createQuery(PersonaEntity.class);
        Root<PersonaEntity> root = query.from(PersonaEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {

            switch (field){
                case "usuario":
                    predicates.add(cb.like(root.get(field),(String)value));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),(String)value));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),(String)value));
                    break;
                case "created_date":
                    String dateCondition = (String) conditions.get("dateCondition");
                    switch(dateCondition){
                        case "greater":
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case "less":
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
                case "orderBy":
                    query.orderBy(cb.asc(root.get((String)value)));
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        int pageSize = 10;
        if(conditions.get(pageSize) != null){
            pageSize= Integer.parseInt((String)conditions.get("pageSize"));
        }
        return entityManager.createQuery(query).setMaxResults(pageSize).getResultList();
    }


}
