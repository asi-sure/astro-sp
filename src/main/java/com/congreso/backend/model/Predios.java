package com.congreso.backend.model;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Predios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String codpre;
    private Long codsec;
    private String nombre;
    private int estado;
    private String libre;
}
