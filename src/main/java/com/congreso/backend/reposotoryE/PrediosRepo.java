package com.congreso.backend.reposotoryE;

import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.entities.SeccionesE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrediosRepo extends JpaRepository<PrediosE,String> {
    @Query(value = " SELECT i "+
                   " FROM PrediosE i "+
                   " WHERE i.estado = :estado AND " +
                   " UPPER(i.nombre) LIKE UPPER(:buscar)")
    Page<PrediosE> listarPredios(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);
    @Query( value = " SELECT i " +
                    " FROM PrediosE i " +
                    " WHERE i.estado = :estado AND i.codsec = :xcodsec ")
    List<PrediosE> listarPrediosPorSecciones(
            @Param("estado") int estado,
            @Param("xcodsec") int xcodsec
    );


}
