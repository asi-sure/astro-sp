package com.congreso.backend.entities.forms;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneralResumenForms {
    @NotNull(message = "El responsable es un campo requerido")
    @Min(value = 1, message = "El ID del responsable debe ser un número entero positivo")
    private Integer responsable;

    @NotNull(message = "El mes es un campo requerido")
    @Min(value = 1, message = "El mes debe estar entre 1 y 12")
    @Max(value = 12, message = "El mes debe estar entre 1 y 12")
    private Integer mes;

    @NotNull(message = "La gestión es un campo requerido")
    @Min(value = 2000, message = "La gestión no puede ser menor al año 2000")
    @Digits(integer = 4, fraction = 0, message = "La gestión debe ser un año válido de 4 dígitos")
    private Integer gestion;
}
