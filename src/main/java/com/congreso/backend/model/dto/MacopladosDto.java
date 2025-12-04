package com.congreso.backend.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MacopladosDto {
    private String coda;
    private int gestion;
    private float monto;
    private int estado;
    private String obs;
    private int contador;
    private int cf;
    private LocalDate fecha;
    private int stop;
    private LocalDate fechareg;
    private Integer actualizado_por;
    private LocalDate actualizado_en;
    private Integer eliminado_por;
    private LocalDate eliminado_en;
    private Long ciresp;
    private Long cicli;
}
