package com.congreso.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Secciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long codsec;
    private Long cods;
    private String nombre;
    private int estado;
}
