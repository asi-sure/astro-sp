package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.BoletasContratosE2Dto;
import com.congreso.backend.entities.Dto.BoletasContratosEDto;
import com.congreso.backend.entities.Dto.InquilinoDetalleDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface BoletasContratosS {
    PaginatedResponse<BoletasContratosEDto> BoletasContratosByCocli(long cicli, Pageable pageable);
    ResponseEntity<ApiResponse> obtenerDetalleInquilino(Long id);
//    ResponseEntity<ApiResponse> obtenerBoletasBycodcon(String xcodcon);
    PaginatedResponse<BoletasContratosE2Dto> obtenerBoletasBycodcon(String xcodcon, Pageable pageable);
    ResponseEntity<ApiResponse> obtenerListaDeInquilino();


}
