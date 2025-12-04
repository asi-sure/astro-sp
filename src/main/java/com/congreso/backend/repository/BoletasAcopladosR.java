package com.congreso.backend.repository;

import com.congreso.backend.entities.BoletasAcopladosE;
import com.congreso.backend.model.BoletasAcoplados;
import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.dto.MacopladosDto;
import com.congreso.backend.model.dto.McontratosDto;

import java.time.LocalDate;

public interface BoletasAcopladosR {

    void save_boletasAcoplados(long id_daco, LocalDate xfecha, float xmonto, BoletasAcopladosE bol);

}
