package com.congreso.backend.entities.Dto;

import com.congreso.backend.entities.DcontratosE;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.PersonsE;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class McontratosEDto {
    private String codcon;
    private int gestion;
    private Date fechaini;
    private Date fechafin;
    private int estado;
    private float monto;
    private String obs;
    private int contador;
    private int cf;
    private Date fecha;
    private int stop;
    private Date fechareg;
    private String inquilino;
    private String persona_resp;
    Set<DcontratosE> dcontratos;
}
