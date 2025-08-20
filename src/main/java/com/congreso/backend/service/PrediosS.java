package com.congreso.backend.service;

import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PrediosS {
    PaginatedResponse<PrediosE> findAll(int xestado,int codsec, String buscar, Pageable pageable);
//    ResponseEntity<ApiResponse> listarPrediosPorSeccion(int estado, int codsec);
}
