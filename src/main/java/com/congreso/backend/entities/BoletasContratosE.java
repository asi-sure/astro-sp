package com.congreso.backend.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "boletas_contratos")
public class BoletasContratosE {
    @EmbeddedId
    private BoletasContratosEPK id;
    private int gestion;
    private float monto;
    private float pagado;
    private float condonar;
    private int estado;
    private int estadopago;
    private int creado_por;
    private LocalDate fechareg;
    private int  actualizado_por;
    private LocalDate actualizado_en;
    private int  eliminado_por;
    private LocalDate eliminado_en;
}
