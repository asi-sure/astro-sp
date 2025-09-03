package com.congreso.backend.model;

import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubros implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codc;
    private String nombre;
    private int estado;
    private int tipo;
    private String padre;
    private String deta;
}
