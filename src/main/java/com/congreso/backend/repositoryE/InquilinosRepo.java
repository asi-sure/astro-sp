package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.Dto.InquilinoDetalleDto;
import com.congreso.backend.entities.InquilinosE;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface InquilinosRepo extends JpaRepository<InquilinosE, Long> {
    @Query(
            value = " SELECT i "+
                    " FROM InquilinosE i "+
                    " WHERE i.estado = :estado AND " +
                    " UPPER(CONCAT(i.cedula, i.nombre, COALESCE(i.ap, ''), COALESCE(i.am, ''), COALESCE(i.direc, ''), COALESCE(i.celular, ''))) LIKE UPPER(:buscar)")
    Page<InquilinosE> listarInquilinos(
            @Param("estado") boolean estado,
            @Param("buscar") String buscar,
            Pageable pageable);
    @Query(
            value = " SELECT * " +
                    " FROM inquilinos WHERE id = :id ;",
            nativeQuery = true
    )
    InquilinosE findById(@Param("id") int id);

    @Query("SELECT DISTINCT i FROM InquilinosE i " +
            "LEFT JOIN FETCH i.contratos c " +
            "LEFT JOIN FETCH c.predios p " +
            "LEFT JOIN FETCH p.secciones s " +
            "LEFT JOIN FETCH s.sectores sec " +
            "WHERE i.id = :idInquilino")
    Optional<InquilinoDetalleDto> findInquilinoConContratosById(@Param("idInquilino") Long idInquilino);

    @Query("SELECT DISTINCT i FROM InquilinosE i " +
            "INNER JOIN FETCH i.contratos c " +
            "LEFT JOIN FETCH c.predios p " +
            "LEFT JOIN FETCH p.secciones s " +
            "LEFT JOIN FETCH s.sectores sec " +
            "WHERE i.estado = true")
    List<InquilinoDetalleDto> listaInquilinoConContratos();

}
