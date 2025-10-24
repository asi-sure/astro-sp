package com.congreso.backend.repository;

import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.Dcontratos;
import com.congreso.backend.model.dto.McontratosDto;

import java.time.LocalDate;
import java.util.List;

public interface BoletasContratosR {
//    List<BoletasContratosDto> findByCicli(long cicli);
    void save_boletasContratos(McontratosDto obj, BoletasContratos bol);
    void save_boletas(long id_dcon, BoletasContratos bol);

}
