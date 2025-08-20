package com.congreso.backend.entities.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrediosEDto {
    private String codpre;
    private int codsec;
    private String nombreseccion;
    private String nombre;
    private int estado;
    private String libre;
}
