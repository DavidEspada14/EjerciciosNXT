package com.espada.EJ2.CRUD.Persona.domain.services;

import com.espada.EJ2.CRUD.ErrorsHandling.NotFoundException;
import com.espada.EJ2.CRUD.Persona.domain.PersonaEntity;
import com.espada.EJ2.CRUD.Persona.infraestructure.repositories.PersonaRepo;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaInputDTO;
import com.espada.EJ2.CRUD.Persona.infraestructure.controller.dto.PersonaOutputDTO;
import com.espada.EJ2.CRUD.Profesor.domain.ProfesorEntity;
import com.espada.EJ2.CRUD.Profesor.infraestructure.repositories.ProfesorRepo;
import com.espada.EJ2.CRUD.Student.domain.StudentEntity;
import com.espada.EJ2.CRUD.Student.infraestructure.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepo personaRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ProfesorRepo profesorRepo;

    @Override
    public PersonaOutputDTO addPerson(PersonaInputDTO personaDTO) throws Exception {
        if(personaDTO.getUsuario().length() < 3 || personaDTO.getUsuario().length() > 10){
            throw new Exception("El usuario debe tener entre 3 y 10 caracteres");
        } else {
            PersonaEntity personaEntity = new PersonaEntity(personaDTO);
            personaRepo.save(personaEntity);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(personaEntity);
            return saveOutputDTO;
        }
    }

    @Override
    public PersonaEntity updatePerson(PersonaEntity persona, PersonaInputDTO personaInputDTO) throws Exception {
        PersonaEntity personaActualizada = new PersonaEntity();

        if(personaInputDTO.getIdPersona() != null){ personaActualizada.setIdPersona(personaInputDTO.getIdPersona());
        } else{personaActualizada.setIdPersona(personaInputDTO.getIdPersona());}

        if(personaInputDTO.getName() != null){ personaActualizada.setName(personaInputDTO.getName());
        } else{personaActualizada.setName(personaInputDTO.getName());}

        if(personaInputDTO.getSurname() != null){ personaActualizada.setSurname(personaInputDTO.getSurname());
        } else{personaActualizada.setSurname(personaInputDTO.getSurname());}

        if(personaInputDTO.getUsuario() != null){ personaActualizada.setUsuario(personaInputDTO.getUsuario());
        } else{personaActualizada.setUsuario(personaInputDTO.getUsuario());}

        if(personaInputDTO.getPassword() != null){ personaActualizada.setPassword(personaInputDTO.getPassword());
        } else{personaActualizada.setPassword(personaInputDTO.getPassword());}

        if(personaInputDTO.getCity() != null){ personaActualizada.setCity(personaInputDTO.getCity());
        } else{personaActualizada.setCity(personaInputDTO.getCity());}

        if(personaInputDTO.getPersonal_email() != null){ personaActualizada.setPersonal_email(personaInputDTO.getPersonal_email());
        } else{personaActualizada.setPersonal_email(personaInputDTO.getPersonal_email());}

        if(personaInputDTO.getCompany_email() != null){ personaActualizada.setCompany_email(personaInputDTO.getCompany_email());
        } else{personaActualizada.setCompany_email(personaInputDTO.getCompany_email());}

        if(personaInputDTO.getActive() != null){ personaActualizada.setActive(personaInputDTO.getActive());
        } else{personaActualizada.setActive(personaInputDTO.getActive());}

        if(personaInputDTO.getCreated_date() != null){ personaActualizada.setCreated_date(personaInputDTO.getCreated_date());
        } else{personaActualizada.setCreated_date(personaInputDTO.getCreated_date());}

        if(personaInputDTO.getTermination_date() != null){ personaActualizada.setTermination_date(personaInputDTO.getTermination_date());
        } else{personaActualizada.setTermination_date(personaInputDTO.getTermination_date());}

        if(personaInputDTO.getImagen_url() != null){ personaActualizada.setImagen_url(personaInputDTO.getImagen_url());
        } else{personaActualizada.setImagen_url(personaInputDTO.getImagen_url());}

        personaRepo.deleteById(personaInputDTO.getIdPersona());
        return personaRepo.save(personaActualizada);
    }

    @Override
    public String deletePersonaById(Integer id) throws Exception {
        personaRepo.findById(id).orElseThrow(() -> new NotFoundException ("Persona con id: "+id+" no encontrada."));
        personaRepo.deleteById(id);
        return "Persona con id: "+id+" eliminada correctamente.";
    }

    @Override
    public PersonaEntity findPersonaById(int id) throws Exception{
        return personaRepo.findById(id).orElseThrow(() -> new NotFoundException("Persona con id: "+id+" no encontrada."));
    }

    @Override
    public List<PersonaOutputDTO> findByUser(String usuario) throws Exception {
        return personaRepo.findPersonaByUsuario(usuario);
    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepo.findAll();
    }

    @Override
    public Optional<StudentEntity> findEstudianteByPersonId(Integer id) {
        return studentRepo.findStudentByPersonaID(id);
    }

    @Override
    public Optional<ProfesorEntity> findProfesorByPersonId(Integer id) {
        return profesorRepo.findProfesorByPersonaID(id);
    }


}
