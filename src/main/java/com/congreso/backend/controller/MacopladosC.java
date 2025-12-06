package com.congreso.backend.controller;

import com.congreso.backend.entities.Dto.MacopladosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface MacopladosC {
    PaginatedResponse<MacopladosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable);
    PaginatedResponse<MacopladosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable);
    ResponseEntity<ApiResponse> findByCoda(String xcoda);
    ResponseEntity<ApiResponse> save(MacopladosForms in);
    ResponseEntity<ApiResponse> delete(String coda, int idresponsable);
}
