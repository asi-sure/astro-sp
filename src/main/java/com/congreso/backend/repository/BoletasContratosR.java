package com.congreso.backend.repository;

import com.congreso.backend.entities.forms.DcontratosForms;
import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.forms.InquilinosForm;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BoletasContratosR {

    void save_boletasContratos(List<DcontratosForms> obj, String codcon, BoletasContratos bol, LocalDate xfechaini);

}
