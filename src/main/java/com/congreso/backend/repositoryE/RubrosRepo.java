package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.model.forms.RubrosForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RubrosRepo extends JpaRepository<RubrosE,String> {
    @Query(
            value = " SELECT i "+
                    " FROM RubrosE i "+
                    " WHERE i.estado = :estado AND i.deta='G' AND " +
                    " UPPER(CONCAT(i.codc, i.nombre,COALESCE(i.deta, ''))) LIKE UPPER(:buscar)")
    Page<RubrosE> listarRubros(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);
    @Query(
            value = " SELECT  i.codc,i.nombre,i.estado,i.padre "+
                    " FROM rubros i "+
                    " WHERE i.padre=:codpadre AND i.estado = :estado AND i.deta='D' AND " +
                    " UPPER(CONCAT(i.codc, i.nombre,COALESCE(i.deta, ''))) LIKE UPPER(:buscar)", nativeQuery = true)
    Page<Object[]> listarRubrosByPadre(
            @Param("codpadre") String codpadre,
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            Pageable pageable);
} //end of class
