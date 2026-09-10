package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.Dto.PrivilegiosDto;
import com.congreso.backend.entities.PrivilegiosE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrivilegiosRepo  extends JpaRepository<PrivilegiosE,Integer> {
    @Query(
        value = "SELECT p.id_priv_menu, pr.id_priv, pr.id_subm, pr.alias, pr.descripcion " +
            "FROM mesub m " +
            "   JOIN priv_menu p ON m.id_mesub = p.id_mesub " +
            "   JOIN privilegios pr ON p.id_priv = pr.id_priv " +
            "WHERE m.id_menu = :idMenu AND m.id_subm = :idSubm",
        nativeQuery = true)
    List<PrivilegiosDto> findByMenuIdNative(
            @Param("idMenu") int idMenu,
            @Param("idSubm") int idSubm
    );
    /*
        private int id_priv_menu;
    private int id_priv;
    private int id_subm;
    private String alias;
    private String descripcion;
     */
}
