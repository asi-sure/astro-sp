package com.congreso.backend.repository;

import com.congreso.backend.model.Dcontratos;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface DcontratosR {
    List<Dcontratos> findByCodcon(String codcon);
}
