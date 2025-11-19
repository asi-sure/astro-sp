package com.congreso.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "auditoria_transacciones")
public class AuditoriaTransaccionesE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate momento_transaccion;
//    private long usuario_id;
    private String tipo_operacion;
    private String nombre_tabla;
    private String registro_id;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private PersonsE person;

    @Column(name = "datos_anteriores", columnDefinition = "jsonb")
    // @JdbcTypeCode(SqlTypes.JSON) // Usar si estás en una versión moderna de Hibernate 6+
    private String datos_anteriores;
    @Column(name = "datos_nuevos", columnDefinition = "jsonb")
    // @JdbcTypeCode(SqlTypes.JSON)
    private String datos_nuevos;
    private String descripcion ;
}
