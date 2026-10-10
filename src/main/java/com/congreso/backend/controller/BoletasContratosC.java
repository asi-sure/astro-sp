package com.congreso.backend.controller;

import com.congreso.backend.entities.Dto.BoletasContratosE2Dto;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BoletasContratosC{

    ResponseEntity<ApiResponse> findById(Long id);
//    ResponseEntity<ApiResponse> obtenerBoletasByCondon(String xcodcon);
    PaginatedResponse<BoletasContratosE2Dto> obtenerBoletasByCondon(String xcodcon, Pageable pageable);
    ResponseEntity<ApiResponse> obtenerListaInquilinos();

}
