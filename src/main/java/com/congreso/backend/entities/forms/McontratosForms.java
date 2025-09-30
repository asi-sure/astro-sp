package com.congreso.backend.entities.forms;

import com.congreso.backend.entities.Dto.DcontratosEDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class McontratosForms {
    private String codcon;
    private int gestion;
    private Date fechaini;
    private Date fechafin;
    private int estado;
    private float monto;
    private String obs;
    private Date fecha;
    private Long codcliente;
    private Long codresponsable;
    private int indefinido;
    private List<DcontratosForms> dcontratos;
}
