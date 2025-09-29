package com.congreso.backend.model.dto;

import com.congreso.backend.entities.DcontratosE;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.PersonsE;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class McontratosDto {
    private String codcon;
    private int gestion;
    private Date fechaini;
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
    private Long ciresp;
    private Long cicli;
//    List<DcontratosE> dcontratos;
}
