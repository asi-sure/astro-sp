package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;

public interface McontratosS {
    PaginatedResponse<McontratosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable);
//    PaginatedResponse<McontratosE> findAll_boletasByCicli(long cicli, Pageable pageable);
    PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable);
   ResponseEntity<ApiResponse> save(McontratosForms in);
   ResponseEntity<ApiResponse> delete(String codcon, int idresponsable);
}
