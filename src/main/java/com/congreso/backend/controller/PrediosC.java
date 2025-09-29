package com.congreso.backend.controller;

import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PrediosC {
    PaginatedResponse<PrediosE> findAll(int estado, int codSeccion,String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> findById(String codpre);
    ResponseEntity<ApiResponse> listaPrediosLibres();
    ResponseEntity<ApiResponse> save(Predios obj);
    ResponseEntity<ApiResponse> update(Predios obj, String codpre);
    ResponseEntity<ApiResponse> delete(int estadoactual, String id);
//    ResponseEntity<ApiResponse> prediosPorSector(int estado, int codsec);
}
