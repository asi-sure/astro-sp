package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "boletas_acoplados")
public class BoletasAcopladosE {
    @Id
    private long id_boleta_aco;
    private long id_daco;
    private int mes;
    private int anio;
    private int gestion;
    private float monto;
    private float pagado;
    private float condonar;
    private int estado;
    private int estadopago;
    private long creado_por;
    private LocalDate fechareg;
    private Integer  actualizado_por;
    private LocalDate actualizado_en;
    private Integer  eliminado_por;
    private LocalDate eliminado_en;

    @ManyToOne
    @MapsId("id_daco")
    @JoinColumn(name = "id_daco")
    @JsonBackReference
    DacopladosE dacoplados;
}
