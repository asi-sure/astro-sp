package com.congreso.backend.repository;

import com.congreso.backend.model.Sectores;

public interface SectoresR {
    Long save(Sectores obj);
    boolean update(Sectores obj, int id);
    boolean delete(int estado,int id);
    //funciones
    public boolean verificarNombre(String nombre, int id);
}
