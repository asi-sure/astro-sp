package com.congreso.backend.repository;

import com.congreso.backend.model.Sectores;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface SectoresR {
    Long save(Sectores obj);
    boolean update(Sectores obj, int id);

    public boolean verificarNombre(String nombre, int id);
}
