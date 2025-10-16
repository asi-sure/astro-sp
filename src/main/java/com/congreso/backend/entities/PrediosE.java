package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "predios")
public class PrediosE {

    @Id
    String codpre;
    @Column(name = "codsec", nullable = false)
    int codsec;
    @Column(name = "nombre", nullable = false)
    String nombre;
    @Column(name = "estado", nullable = false)
    int estado;
    @Column(name = "libre",  nullable = false)
    String libre;

    @ManyToOne
    @MapsId("codsec")
    @JoinColumn(name = "codsec")
    @JsonBackReference
    SeccionesE secciones;

//    @OneToMany(mappedBy = "predios")
//    @JsonBackReference
//    Set<DcontratosE> dcontratos;

    @OneToMany(mappedBy = "predios")
    @JsonBackReference
    Set<McontratosE> mcontratos;

}
