package com.congreso.backend.repository;

import com.congreso.backend.model.Sectores;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface SectoresR {
    Long save(Sectores obj);


    public boolean verificarNombre(String nombre);
}
