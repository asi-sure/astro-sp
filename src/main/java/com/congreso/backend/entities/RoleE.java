package com.congreso.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "role")
public class RoleE {
    @Id
    private Long id_role;

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

    private boolean status;

} //end of class
