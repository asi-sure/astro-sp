package com.congreso.backend.reposotoryE;

import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SectoresRepo extends JpaRepository<SectoresE, Long> {
    @Query(
            value = " SELECT i "+
                    " FROM SectoresE i "+
                    " WHERE i.estado = :estado AND " +
                    " UPPER(i.nombre) LIKE UPPER(:buscar)")
    Page<SectoresE> listarSectores(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);

    @Query(
            value = "SELECT new com.congreso.backend.entities.Dto.SectoresEDto(i.cods, i.nombre, i.estado) " +
                    "FROM SectoresE i " +
                    "WHERE i.estado = :estado " +
                    "AND UPPER(i.nombre) LIKE UPPER(:buscar)"
    )
    Page<SectoresEDto> listarSectoresDto(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable
    );
}  //the end
