package com.congreso.backend.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeccionesEDto {
    private Long codsec;
    private Long cods;
    private String nombresector;
    private String nombre;
    private int estado;
}

