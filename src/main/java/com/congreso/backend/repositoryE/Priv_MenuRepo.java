package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.Priv_MenuE;
import com.congreso.backend.entities.PrivilegiosE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Priv_MenuRepo extends JpaRepository<Priv_MenuE,Integer> {
    //llamado desde Privilegios
    @Modifying // 👈 Obligatorio para operaciones INSERT, UPDATE o DELETE
    @Transactional // 👈 Garantiza que se ejecute dentro de una transacción
    @Query(
            value = "insert into priv_menu(id_mesub, id_priv) " +
                    "values(?, ?) ",
            nativeQuery = true)
    int add_privMenu(
            @Param("idMesub") int idMesub,
            @Param("idPriv") int idPriv
    );

    @Modifying // 👈 Obligatorio para operaciones INSERT, UPDATE o DELETE
    @Transactional // 👈 Garantiza que se ejecute dentro de una transacción
    @Query(
            value = "delete from priv_menu where id_priv_menu = :idPrivMenu " ,
            nativeQuery = true)
    int del_privMenu(
            @Param("idPrivMenu") int idPrivMenu
    );


}
