package com.congreso.backend.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletasContratos implements Serializable {
    private static final long serialVersionUID = 1L;

    protected long id_boleta_con;
    protected long id_dcon;;
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
