package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "secciones")
public class SeccionesE {
    @Id
    private Long codsec;

    @Column(name = "cods", nullable = false)
    private Long cods;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado")
    private int estado;

    @ManyToOne
    @MapsId("cods")
    @JoinColumn(name = "cods")
    @JsonBackReference
    SectoresE sectores;

    @OneToMany(mappedBy = "secciones")
    @JsonManagedReference
    Set<PrediosE> predios;
}
