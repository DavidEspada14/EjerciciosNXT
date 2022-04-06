package com.nxt.BS2;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    public String getPoblacion(){
        return persona.getPoblacion();
    }

    public void setPoblacion(String poblacion){
        persona.setPoblacion(poblacion);
    }

    public int getEdad(){
        return persona.getEdad();
    }

    public void setEdad(int edad){
        persona.setEdad(edad);
    }

    @Override
    public Persona getPersona() {
        return this.persona;
    }
}
