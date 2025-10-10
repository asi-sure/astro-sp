package com.congreso.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dcontratos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id_dcon;
    protected String codcon;
    protected String codc;
    protected String codpre;
    private float importe;
    private int principal;
    private int lectura;

}
