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
@Table(name = "privilegios")
public class PrivilegiosE {
    @Id
    private Long id_priv;

    private int id_subm;

    @Column(name = "alias", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 5)
    private String alias;

    @Column(name = "descripcion", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 100)
    private String descripcion;

    @ManyToOne
    @MapsId("id_subm")
    @JoinColumn(name = "id_subm")
    @JsonBackReference
    SubmenuE submenu;

    @OneToMany(mappedBy = "privilegios")
    @JsonBackReference
    Set<Priv_MenuE> priv_menu;

}
