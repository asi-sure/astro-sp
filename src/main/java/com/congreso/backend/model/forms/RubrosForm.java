package com.congreso.backend.model.forms;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RubrosForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codc;
    private String nombre;
    private int estado;
    private String padre;
}
