package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "macoplados")
public class MacopladosE {
    @Id
    private String coda;
    private int gestion;
    private int estado;
    private float monto;
    private String obs;
    private int contador;
    private int cf;
    private LocalDate fecha;
    private int stop;

    private LocalDate fechareg;

    private Integer actualizado_por;
    private LocalDate actualizado_en;

    private Integer eliminado_por;
    private LocalDate eliminado_en;

    @ManyToOne
    @JoinColumn(name="cicli")
    @JsonManagedReference
    private InquilinosE inquilino;

    @ManyToOne
    @JoinColumn(name="ciresp")
    @JsonManagedReference
    private PersonsE persona_resp;

    @OneToMany(mappedBy = "macoplados")
    @JsonManagedReference
    List<DacopladosE> dacoplados;

}
