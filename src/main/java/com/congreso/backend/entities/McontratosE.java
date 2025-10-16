package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mcontratos")
public class McontratosE {

    @Id
    private String codcon;
    protected String codc;
    protected String codpre;
    private String tipocon;
    private int gestion;

    @NotNull(message = "Campo requerido")
    @NotBlank
    private LocalDate fechaini;

    @NotNull(message = "Campo requerido")
    @NotBlank
    private LocalDate fechafin;

    private int estado;

    private float monto;

    private String obs;

    private int contador;

    private int cf;

    private LocalDate fecha;

    private int indefinido;

    private int stop;

    private LocalDate fechareg;

    private Integer actualizado_por;
    private LocalDate actualizado_en;

    private Integer eliminado_por;
    private LocalDate eliminado_en;

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

    @ManyToOne
    @JoinColumn(name="cicli")
    @JsonManagedReference
    private InquilinosE inquilino;

    @ManyToOne
    @JoinColumn(name="ciresp")
    @JsonManagedReference
    private PersonsE persona_resp;

    @OneToMany(mappedBy = "mcontratos")
    @JsonManagedReference
    List<DcontratosE> dcontratos;
}
