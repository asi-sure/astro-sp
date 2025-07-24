package com.congreso.backend.reposotoryE;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.model.forms.InquilinosForm;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

public interface InquilinosRepo extends JpaRepository<InquilinosE, Long> {
    @Query(
            value = " SELECT id,cedula,nombre,ap,am,direc,celular,ubicacion,estado "+
                    " FROM inquilinos "+
                    " WHERE (estado = :estado )and(upper(cedula||nombre||COALESCE(ap, '')||COALESCE(am, '')||COALESCE(direc, '')||COALESCE(celular, '')) like upper(:buscar) ) ;",
            countQuery = " SELECT count(*) "+
                    " FROM inquilinos "+
                    " WHERE (estado = :estado )and(upper(cedula||nombre||COALESCE(ap, '')||COALESCE(am, '')||COALESCE(direc, '')||COALESCE(celular, '')) like upper(:buscar) ) ;",
            nativeQuery = true
    )
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


}
