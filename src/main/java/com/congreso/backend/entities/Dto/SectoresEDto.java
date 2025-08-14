package com.congreso.backend.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectoresEDto {
    private Long cods;
    private String nombre;
    private int estado;
}
