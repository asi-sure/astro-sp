package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface McontratosRepo extends JpaRepository<McontratosE, String> {

    @Query(
            value = " SELECT i "+
                    " FROM McontratosE i "+
                    " WHERE i.estado = :estado and "+
                    " UPPER(CONCAT(i.codcon,i.inquilino.nombre ,i.inquilino.ap,i.inquilino.am,i.persona_resp.name,i.persona_resp.firstName,i.persona_resp.secondName)) LIKE UPPER(:buscar) and"+
                    " (i.fecha between :fechaini and :fechafin) ")
    Page<McontratosE> listarMcontratos(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            @Param("fechaini") LocalDate fechaini,
            @Param("fechafin") LocalDate fechafin,
            Pageable pageable);


    /*
     @Query(
            value = " SELECT i "+
                    " FROM McontratosE i "+
                    " WHERE i.estado = :estado AND " +
                    " UPPER(i.nombre) LIKE UPPER(:buscar)")
    Page<SectoresE> listarSectores(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);
     */
}
