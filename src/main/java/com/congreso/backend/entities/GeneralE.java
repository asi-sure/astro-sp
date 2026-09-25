package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "general")
public class GeneralE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo requerido")
    private int gestion;

    @NotNull(message = "Campo requerido")
    private int contratos;

    @NotNull(message = "Campo requerido")
    private int acoplados;

//    @NotNull(message = "Campo requerido")
//    private int mes;

    @NotNull(message = "Campo requerido")
    private int anio;

    @OneToOne
    @JoinColumn(name="mes")
    @JsonManagedReference
    private MesesE meses;
}
