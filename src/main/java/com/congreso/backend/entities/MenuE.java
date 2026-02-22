package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "menu")
public class MenuE {
    @Id
    private Long id_menu;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 150)
    private String description;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(name = "type_menu", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 50)
    private String type_menu;

    private boolean status;

    @Column(name = "icon", nullable = false)
    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 150)
    private String icon;

    @OneToMany(mappedBy = "menu")
    @JsonBackReference
    Set<MesubE> mesub;
}

