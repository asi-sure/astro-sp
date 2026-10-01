package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.Dto.GeneralResumenDto;
import com.congreso.backend.entities.GeneralE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GeneralRepo extends JpaRepository<GeneralE,Integer> {
    @Query("SELECT g.id AS id, g.gestion AS gestion, m.nombre AS mesesNombre " +
           "FROM GeneralE g JOIN g.meses m")
    List<GeneralResumenDto> findResumenGeneral();

    // El guion bajo le dice explícitamente a Spring: "Entra a 'meses' y busca 'id'"
    Optional<GeneralE> findByGestionAndMeses_Id(int gestion, int idMes);

    //llamada a una FUNCTION de la base de datos
    @Query(value = "SELECT generar_boletas(:xresponsable,:xmes, :xgestion)", nativeQuery = true)
    int genererBoletasParaTodos(
            @Param("xresponsable") int xresponsable,
            @Param("xmes") int xmes,
            @Param("xgestion") int xgestion
    );
}
