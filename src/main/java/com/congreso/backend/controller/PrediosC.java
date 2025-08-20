package com.congreso.backend.controller;

import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PrediosC {
    PaginatedResponse<PrediosE> findAll(int estado, int codSeccion,String buscar, Pageable pageable);
//    ResponseEntity<ApiResponse> prediosPorSector(int estado, int codsec);
}
