package com.congreso.backend.service;

import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PrediosS {
    PaginatedResponse<PrediosE> findAll(int xestado,int codsec, String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> findById(String codpre);
    ResponseEntity<ApiResponse> save(Predios obj);
    ResponseEntity<ApiResponse> update(Predios obj, String id);
    ResponseEntity<ApiResponse> delete(int estado,String id);
//    ResponseEntity<ApiResponse> listarPrediosPorSeccion(int estado, int codsec);
}
