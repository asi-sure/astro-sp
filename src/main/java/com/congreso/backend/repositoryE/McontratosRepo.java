package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.SectoresE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    //llamada a una FUNCTION de la base de datos
    @Query(value = "SELECT delete_contratos(:xcodcon, :xresponsable)", nativeQuery = true)
    Boolean callDeleteContratosNative(
            @Param("xcodcon") String xcodcon,
            @Param("xresponsable") int xresponsable
    );

//    @Query(
//            value = " SELECT i "+
//                    " FROM  McontratosE i "+
//                    "       JOIN i.dcontratos d "+
//                    "       JOIN d.boletasContratos b "+
//                    " WHERE i.inquilino.id = :cicli and "+
//                    "       b.pagado < b.monto  ")
//    //deberia modificar a pagados y no pagados
//    Page<McontratosE> boletasByInquilinos(
//            @Param("cicli") long cicli,
//            Pageable pageable);






//    @Query(
//    value = "SELECT DISTINCT m "+
//            "FROM McontratosE m " +
//            "JOIN m.dcontratos d " + // Une con DcontratosE
//            "JOIN d.boletasContratos b " + // Une con BoletasContratosE
//            "WHERE m.inquilino.cedula = :cicli AND " +
//            "b.estado = 1 " // Ejemplo: Condición en un atributo de BoletasContratosE
//    )
//    Page<McontratosE> boletasByInquilinos(
//        @Param("cicli") String cicli,
//        Pageable pageable
//    );
//
//     @Query(
//            value = " SELECT i "+
//                    " FROM McontratosE i "+
//                    " WHERE i.estado = :estado AND " +
//                    " UPPER(i.nombre) LIKE UPPER(:buscar)")
//    Page<SectoresE> listarSectores(
//            @Param("estado") int estado,
//            @Param("buscar") String buscar,
//            Pageable pageable);

} //end of class
