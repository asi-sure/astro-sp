package com.congreso.backend.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inquilinos_datE {

    @NotNull(message = "Campo requerido")
    private Long id;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 20, min = 6)
    private String cedula;
}
