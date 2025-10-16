package com.congreso.backend.repository;

import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.Dcontratos;

import java.time.LocalDate;
import java.util.List;

public interface BoletasContratosR {
//    List<BoletasContratosDto> findByCicli(long cicli);
    void save_boletasContratos(Dcontratos det, BoletasContratos bol, LocalDate xfechaini);

}
