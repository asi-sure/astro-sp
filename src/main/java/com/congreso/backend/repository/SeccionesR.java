package com.congreso.backend.repository;

import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.Sectores;

public interface SeccionesR {

    Long save(Secciones obj);

    public boolean verificarNombre(String nombre, int id);

}
