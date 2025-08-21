package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.SeccionesE;
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
    @Query(
            value = " SELECT new com.congreso.backend.entities.Dto.SeccionesEDto(i.codsec,i.cods,e.nombre,i.nombre, i.estado) " +
                    " FROM SeccionesE i, SectoresE e" +
                    " WHERE (i.estado = :estado)AND(i.cods between :xcods1 and :xcods2)" +
                    " AND(UPPER(i.nombre) LIKE UPPER(:buscar))AND(i.cods=e.cods)"
    )
    Page<SeccionesEDto> listarSeccionesDto(
            @Param("estado") int estado,
            @Param("xcods1") int xcods1,
            @Param("xcods2") int xcods2,
            @Param("buscar") String buscar,
            Pageable pageable
    );


} //End of the Class
