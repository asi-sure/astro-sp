package com.congreso.backend.entities.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletasContratosDetalleEDto {
    private String rubros;
    private String predios;
    private long id_boleta_con;
    private int mes;
    private int anio;
    private float monto;
    private float pagado;
    private float condonar;
}
