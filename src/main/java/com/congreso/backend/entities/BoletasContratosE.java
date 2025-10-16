package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @Id
    private long id_boleta_con;
    private long id_dcon;
    private int mes;
    private int anio;
    private int gestion;
    private float monto;
    private float pagado;
    private float condonar;
    private int estado;
    private int estadopago;
    private int creado_por;
    private LocalDate fechareg;
    private Integer  actualizado_por;
    private LocalDate actualizado_en;
    private Integer  eliminado_por;
    private LocalDate eliminado_en;

    @ManyToOne
    @MapsId("id_dcon")
    @JoinColumn(name = "id_dcon")
    @JsonBackReference
    DcontratosE dcontratos;
}
