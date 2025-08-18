package com.congreso.backend.reposotoryE;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeccionesRepo extends JpaRepository<SeccionesE, Long> {
    @Query(
            value = " SELECT i "+
                    " FROM SeccionesE i "+
                    " WHERE i.estado = :estado AND " +
                    " UPPER(i.nombre) LIKE UPPER(:buscar)")
    Page<SeccionesE> listarSecciones(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);
}
