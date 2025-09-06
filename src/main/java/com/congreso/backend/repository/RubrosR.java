package com.congreso.backend.repository;

import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.model.forms.RubrosForm;

import java.util.List;

public interface RubrosR {
    RubrosForm findByCodc(String codc);
    List<RubrosForm> findSoloPadre();
    String save(RubrosForm obj);
    boolean update(RubrosForm obj, String codc);

//////////// EXTRAS
    boolean verificarKey(String codc);
    boolean verificarNombre(String codc, String nombre);

}
