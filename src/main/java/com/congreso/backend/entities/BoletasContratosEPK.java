package com.congreso.backend.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BoletasContratosEPK implements Serializable {
    protected String codcon;
    protected String codc;
    protected String codpre;
    protected int mes;
    protected int anio;
}
