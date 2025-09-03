package com.congreso.backend.repository;

import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.model.forms.RubrosForm;

import java.util.List;

public interface RubrosR {
    RubrosForm findByCodc(String codc);
    List<RubrosForm> findAllPadre();

    String save(RubrosForm obj);

}
