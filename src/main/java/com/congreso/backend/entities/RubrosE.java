package com.congreso.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rubros")
public class RubrosE {
    @Id
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 20, min = 3)
    private String codc;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 200, min = 3)
    private String nombre;

    private int estado;

    private int tipo;

    @Size(max = 20, min = 3)
    private String padre;

    @Size(max = 1)
    private String deta;
}
