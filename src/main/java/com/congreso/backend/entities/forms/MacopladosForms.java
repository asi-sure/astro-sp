package com.congreso.backend.entities.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class MacopladosForms {
    private String coda;
    private int gestion;
    private int estado;
    private String obs;
    private LocalDate fecha;
    private Long codcliente;
    private Long codresponsable;
    private List<DacopladosForms> dacoplados;
}
