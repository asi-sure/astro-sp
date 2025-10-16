package com.congreso.backend.entities;

import com.congreso.backend.model.Predios;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dcontratos")
public class DcontratosE {
    @Id
    private long id_dcon;

    protected String codcon;
    protected String codc;
    private float importe;
    private int estado;

    @ManyToOne
    @MapsId("codcon")
    @JoinColumn(name = "codcon")
    @JsonBackReference
    McontratosE mcontratos;

    @ManyToOne
    @MapsId("codc")
    @JoinColumn(name = "codc")
    @JsonManagedReference
    RubrosE rubros;

//    @OneToMany(mappedBy = "dcontratos", fetch = FetchType.EAGER) // <--- ADDED FETCH TYPE
//    @JsonManagedReference
//    List<BoletasContratosE> boletasContratos;

}
