package com.congreso.backend.entities.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BoletasContratosEDto {
    private long id_inquilino;
    private String cedula;
    private String inquilino;
    List<BoletasContratosDetalleEDto> detalle;
}
