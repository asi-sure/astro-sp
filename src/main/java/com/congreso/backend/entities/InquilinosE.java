package com.congreso.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inquilinos")
public class InquilinosE {

    @Id
    @GeneratedValue(generator = "company_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 50, min = 3)
    private String nombre;

    @Size(max = 40)
    private String ap;

    @Size(max = 40)
    private String am;

    @Size(max = 100)
    private String direc;

    @Size(max = 20)
    private String celular;

    @Size(max = 200)
    private String ubicacion;
}
