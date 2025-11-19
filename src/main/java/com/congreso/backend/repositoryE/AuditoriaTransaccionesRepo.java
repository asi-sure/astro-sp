package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.AuditoriaTransaccionesE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AuditoriaTransaccionesRepo extends JpaRepository<AuditoriaTransaccionesE, Long> {
    @Query(  //Tipo_Operacion = UPDATE - DELETE - STOP - TODOS
            value = " SELECT i "+
                    " FROM AuditoriaTransaccionesE i "+
                    " WHERE UPPER(CONCAT(i.descripcion, i.nombre_tabla, i.registro_id)) LIKE UPPER(:buscar) and"+
                    "       (i.momento_transaccion between :fechaini and :fechafin) and (UPPER(i.tipo_operacion) LIKE UPPER(:tipo_operacion)) ")
    Page<AuditoriaTransaccionesE> listarAuditoriasTransacciones(
            @Param("buscar") String buscar,
            @Param("fechaini") LocalDate fechaini,
            @Param("fechafin") LocalDate fechafin,
            @Param("tipo_operacion") String tipo_operacion,
            Pageable pageable);
}

