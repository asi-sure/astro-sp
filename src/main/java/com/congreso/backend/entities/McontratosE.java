package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    private int gestion;

    @NotNull(message = "Campo requerido")
    @NotBlank
    private Date fechaini;

    @NotNull(message = "Campo requerido")
    @NotBlank
    private Date fechafin;

    private int estado;

    private String tipoper;

    private float monto;

    private String obs;

    private int contador;

    private int cf;

    private Date fecha;

    private int indefinido;

    private int stop;

    private Date fechareg;

    private Integer actualizado_por;
    private Date actualizado_en;

    private Integer eliminado_por;
    private Date eliminado_en;

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
