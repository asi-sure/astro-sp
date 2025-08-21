package com.congreso.backend.repository;

import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Secciones;

public interface PrediosR {
    String save(Predios obj);
    boolean update(Predios obj, String id);
    public boolean verificarNombre(String nombre, String id);
}
