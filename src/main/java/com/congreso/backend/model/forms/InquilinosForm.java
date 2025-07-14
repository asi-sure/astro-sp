package com.congreso.backend.model.forms;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquilinosForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @Size(max = 20, min = 5)
    private String cedula;
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
    private Boolean estado;
}
