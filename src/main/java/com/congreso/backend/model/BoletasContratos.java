package com.congreso.backend.model;

import com.congreso.backend.entities.BoletasContratosEPK;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletasContratos implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String codcon;
    protected String codc;
    protected String codpre;
    protected int mes;
    protected int anio;
    private int gestion;
    private float monto;
    private float pagado;
    private float condonar;
    private int estado;
    private int estadopago;
    private long creado_por;
    private LocalDate fechareg;
    private long  actualizado_por;
    private LocalDate actualizado_en;
    private long  eliminado_por;
    private LocalDate eliminado_en;
}
