package com.congreso.backend.model;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dacoplados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id_daco;
    protected String coda;
    protected String codc;
    private float importe;
    private int estado;
}
