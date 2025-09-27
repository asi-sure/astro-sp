package com.congreso.backend.entities.Dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class McontratosEDto {
    private String codcon;
    private int gestion;
    private Date fechaini;
    private Date fechafin;
    private int estado;
    private float monto;
    private String obs;
    private int contador;
    private int cf;
    private Date fecha;
    private int stop;
    private Date fechareg;
    private String inquilino;
    private String persona_resp;
    List<DcontratosEDto> dcontratos;
}
