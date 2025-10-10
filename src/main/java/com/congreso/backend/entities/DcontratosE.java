package com.congreso.backend.entities;

import com.congreso.backend.model.Predios;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dcontratos")
public class DcontratosE {

//    @EmbeddedId
//    private DcontratosEPK id;
    @Id
    private long id_dcon;

    protected String codcon;
    protected String codc;
    protected String codpre;

    private float importe;

    private int principal;

    private int lectura;

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

    @ManyToOne
    @MapsId("codpre")
    @JoinColumn(name = "codpre")
    @JsonManagedReference
    PrediosE predios;
}
