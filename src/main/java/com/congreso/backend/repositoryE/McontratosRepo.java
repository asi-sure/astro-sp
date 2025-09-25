package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface McontratosRepo extends JpaRepository<McontratosE, String> {

    @Query(
            value = " SELECT i "+
                    " FROM McontratosE i "+
                    " WHERE i.estado = :estado ")
    Page<McontratosE> listarMcontratos(
            @Param("estado") int estado,
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
