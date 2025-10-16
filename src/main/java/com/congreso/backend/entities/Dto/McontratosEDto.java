package com.congreso.backend.entities.Dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class McontratosEDto {
    private String codcon;
    private String predio;
    private String rubro;
    private int gestion;
    private LocalDate fechaini;
    private LocalDate fechafin;
    private int estado;
    private float monto;
    private String obs;
    private int contador;
    private int cf;
    private LocalDate fecha;
    private int stop;
    private LocalDate fechareg;
    private String inquilino;
    private String persona_resp;
    List<DcontratosEDto> dcontratos;
}
