package com.congreso.backend.entities.Dto;

import java.time.LocalDate;

public interface BoletasContratosE2Dto {
    int getId_boleta_con();
    int getMes();
    int getAnio();
    int getGestion();
    float getMonto();
    float getPagado();
    float getCondonar();
    int getEstado();
    int getEstadopago();
    LocalDate getFechareg();
}
