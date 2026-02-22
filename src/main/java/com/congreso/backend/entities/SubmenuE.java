package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "submenu")
public class SubmenuE {
    @Id
    private int id_subm;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 20)
    private String name;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 150)
    private String description;

    @Column(name = "status", nullable = false)
    @NotNull(message = "Campo requerido")
    private boolean status;

    @Column(name = "link", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 100)
    private String link;

    @OneToMany(mappedBy = "submenu")
    @JsonManagedReference
    Set<PrivilegiosE> privilegios;

}
