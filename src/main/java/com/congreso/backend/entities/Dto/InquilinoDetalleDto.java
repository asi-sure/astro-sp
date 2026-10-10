package com.congreso.backend.entities.Dto;

import java.time.LocalDate;
import java.util.List;

public interface InquilinoDetalleDto {
    Long getId();
    String getNombre();
    String getAp();
    String getAm();
    List<ContratoDto> getContratos();

    interface ContratoDto {
        String getCodcon();
        PredioDto getPredios();
    }
   interface PredioDto {
        String getCodpre();
        String getNombre();
        SeccionDto getSecciones();
    }
    interface SeccionDto {
        Long getCodsec();
        String getNombre();
        SectorDto getSectores();
    }
    interface SectorDto {
        Long getCods();
        String getNombre();
    }
}
