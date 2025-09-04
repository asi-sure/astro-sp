package com.congreso.backend.model.forms;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RubrosForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codc;
    private String nombre;
    private int estado;
    private String padre;
    // Explicit constructor to match the query order
    public RubrosForm(String codc, String nombre, int estado, String padre) {
        this.codc = codc;
        this.nombre = nombre;
        this.estado = estado;
        this.padre = padre;
    }
}
