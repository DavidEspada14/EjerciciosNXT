package com.nxt.BS2;

import java.util.List;

public interface CiudadService {
    String getNombre();
    void setNombre(String ciudad);
    int getNumeroHabitantes();
    void setNumeroHabitantes(int numeroHabitantes);
    void addCiudad(Ciudad ciudad);
    List<Ciudad> listCiudad();
    Ciudad getCiudad();
}
