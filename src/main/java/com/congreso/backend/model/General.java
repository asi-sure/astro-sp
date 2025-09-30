package com.congreso.backend.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class General implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private int gestion;
    private int contratos;
    private int acoplados;
    private int mes;
    private int anio;
}
