package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.McontratosE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface MacopladosRepo extends JpaRepository<MacopladosE, String> {
    @Query(
            value = " SELECT i "+
                    " FROM MacopladosE i "+
                    " WHERE i.estado = :estado and "+
                    " UPPER(CONCAT(i.coda,i.inquilino.nombre ,i.inquilino.ap,i.inquilino.am,i.persona_resp.name,i.persona_resp.firstName,i.persona_resp.secondName)) LIKE UPPER(:buscar) and"+
                    " (i.fecha between :fechaini and :fechafin) and (i.stop= :stop) ")
    Page<MacopladosE> listarMacoplados(
            @Param("estado") int estado,
            @Param("buscar") String buscar,
            @Param("fechaini") LocalDate fechaini,
            @Param("fechafin") LocalDate fechafin,
            @Param("stop") int stop,
            Pageable pageable);
    @Query(
            value = " SELECT i "+
                    " FROM MacopladosE i "+
                    " WHERE i.coda = :xcoda ")
    MacopladosE obtenerMacoplados(
            @Param("xcoda") String xcoda);
    //llamada a una FUNCTION de la base de datos
    @Query(value = "SELECT delete_acoplados(:xcoda, :xresponsable)", nativeQuery = true)
    Boolean callDeleteAcopladosNative(
            @Param("xcoda") String xcoda,
            @Param("xresponsable") int xresponsable
    );
    @Query(value = "SELECT modificar_acoplados(:xcoda, :xresponsable)", nativeQuery = true)
    Boolean callModificarAcoplados(
            @Param("xcoda") String xcoda,
            @Param("xresponsable")  int xresponsable
    );
    @Query(value = "SELECT parar_acoplados(:xcoda, :xresponsable,:xobs)", nativeQuery = true)
    Boolean callStopAcoplados(
            @Param("xcoda") String xcoda,
            @Param("xresponsable") int xresponsable,
            @Param("xobs") String xobs
    );


} //end of class
