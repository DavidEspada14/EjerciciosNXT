package com.nxt.BS2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService{
    List<Ciudad> listaCiudades = new ArrayList<>();

    Ciudad ciudad = new Ciudad();


    @Override
    public String getNombre() {
        return ciudad.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        ciudad.setNombre(nombre);
    }

    @Override
    public int getNumeroHabitantes() {
        return ciudad.getNumeroHabitantes();
    }

    @Override
    public void setNumeroHabitantes(int numeroHabitantes) {
        ciudad.setNumeroHabitantes(numeroHabitantes);
    }

    @Override
    public void addCiudad(Ciudad ciudad) {
        listaCiudades.add(ciudad);
    }

    @Override
    public List<Ciudad> listCiudad() {
        return this.listaCiudades;
    }

    @Override
    public Ciudad getCiudad() {
        return this.ciudad;
    }
}
