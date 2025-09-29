package com.congreso.backend.entities.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DcontratosForms {
    private String codc;
    private String codpre;
    private float importe;
    private int principal;
}
