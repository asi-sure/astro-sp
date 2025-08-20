package com.congreso.backend.reposotoryE;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    @Query(
            value = " SELECT new com.congreso.backend.entities.Dto.SeccionesEDto(i.codsec,i.cods, i.nombre, i.estado) " +
                    " FROM SeccionesE i " +
                    " WHERE (i.estado = :estado)AND(i.cods between :xcods1 and :xcods2)" +
                    " AND(UPPER(i.nombre) LIKE UPPER(:buscar))"
    )
    Page<SeccionesEDto> listarSeccionesDto(
            @Param("estado") int estado,
            @Param("xcods1") int xcods1,
            @Param("xcods2") int xcods2,
            @Param("buscar") String buscar,
            Pageable pageable
    );


} //End of the Class
