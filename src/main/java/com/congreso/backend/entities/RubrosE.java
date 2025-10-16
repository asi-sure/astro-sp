package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rubros")
public class RubrosE {
    @Id
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 20, min = 3)
    private String codc;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 200, min = 3)
    private String nombre;

    private int estado;

    private int tipo;

    @Size(max = 1)
    private String deta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padre", referencedColumnName = "codc")
    @JsonBackReference
    private RubrosE padre;

    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RubrosE> hijos;

    @OneToMany(mappedBy = "rubros")
    @JsonBackReference
    Set<DcontratosE> dcontratos;

    @OneToMany(mappedBy = "rubros")
    @JsonBackReference
    Set<McontratosE> mcontratos;
}
