package com.congreso.backend.repositoryE;

import com.congreso.backend.entities.MenuE;
import com.congreso.backend.entities.MesubE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MesubRepo extends JpaRepository<MesubE,Integer> {
    @Query(
            value = "SELECT EXISTS(" +
                    "   SELECT 1 FROM mesub " +
                    "   WHERE id_menu = :idMenu AND id_subm = :idSubm" +
                    ")",
            nativeQuery = true)
    boolean existsMesub_ByIdMenuAndIdSubm(
            @Param("idMenu") int idMenu,
            @Param("idSubm") int idSubm
    );

}//end of class
