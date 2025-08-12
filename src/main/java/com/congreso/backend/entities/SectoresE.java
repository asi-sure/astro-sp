package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sectores")
public class SectoresE {
    @Id
    private Long cods;

    @Column(name = "nombre", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 100)
    private String nombre;

    @Column(name = "estado")
    private int estado;

    @OneToMany(mappedBy = "sectores")
    @JsonManagedReference
    Set<SeccionesE> secciones;
}

