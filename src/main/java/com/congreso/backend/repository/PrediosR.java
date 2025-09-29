package com.congreso.backend.repository;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.dto.PrediosDto;

import java.util.List;

public interface PrediosR {
    Predios findById(String codpre);
    List<PrediosDto> listarPrediosLibres();
    String save(Predios obj);
    boolean update(Predios obj, String id);
    boolean delete(int estado,String id);
    public boolean verificarNombre(String nombre, String id);
}
