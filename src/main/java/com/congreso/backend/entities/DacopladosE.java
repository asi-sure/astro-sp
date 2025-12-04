package com.congreso.backend.entities;

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
@Table(name = "dacoplados")
public class DacopladosE {
    @Id
    private long id_daco;
    protected String coda;
    protected String codc;
    private float importe;
    private int estado;

    @ManyToOne
    @MapsId("coda")
    @JoinColumn(name = "coda")
    @JsonBackReference
    MacopladosE macoplados;

    @ManyToOne
    @MapsId("codc")
    @JoinColumn(name = "codc")
    @JsonManagedReference
    RubrosE rubros;

}
