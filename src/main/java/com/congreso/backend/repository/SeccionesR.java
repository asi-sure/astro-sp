package com.congreso.backend.repository;

import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.Sectores;

public interface SeccionesR {

    Long save(Secciones obj);
    boolean update(Secciones obj, int id);
    boolean delete(int estado,int id);
    public boolean verificarNombre(String nombre, int id);

}
