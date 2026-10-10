package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.BoletasContratosE;
import com.congreso.backend.entities.Dto.BoletasContratosE2Dto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoletasContratosRepo extends JpaRepository<BoletasContratosE,Integer> {
//    List<BoletasContratosE2Dto> findByMcontratos_Codcon(String codcon);
//    @Query("SELECT b FROM BoletasContratosE b WHERE b.mcontratos.codcon = :codcon")
//    List<BoletasContratosE2Dto> findByMcontratos_Codcon(@Param("codcon") String codcon);
    @Query("SELECT b FROM BoletasContratosE b WHERE b.mcontratos.codcon = :codcon")
    Page<BoletasContratosE2Dto> findByMcontratos_Codcon(
            @Param("codcon") String codcon,
            Pageable pageable);

    /*
        @Query(
            value = " SELECT i "+
                    " FROM InquilinosE i "+
                    " WHERE i.estado = :estado AND " +
                    " UPPER(CONCAT(i.cedula, i.nombre, COALESCE(i.ap, ''), COALESCE(i.am, ''), COALESCE(i.direc, ''), COALESCE(i.celular, ''))) LIKE UPPER(:buscar)")
    Page<InquilinosE> listarInquilinos(
            @Param("estado") boolean estado,
            @Param("buscar") String buscar,
            Pageable pageable);
     */

}
