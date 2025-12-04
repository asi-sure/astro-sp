package com.congreso.backend.entities.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DacopladosEDto {
    private long id_daco;
    private String rubro;
    private float importe;
    private int estado;
}
