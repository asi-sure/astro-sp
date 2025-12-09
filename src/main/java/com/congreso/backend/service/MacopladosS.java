package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.MacopladosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.entities.forms.MacopladosForms2;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.entities.forms.McontratosForms2;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface MacopladosS {
    PaginatedResponse<MacopladosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable);
    PaginatedResponse<MacopladosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable);
    ResponseEntity<ApiResponse> findByCoda(String xcodca);
    ResponseEntity<ApiResponse> save(MacopladosForms in);
    ResponseEntity<ApiResponse> delete(String coda, int idresponsable);
    ResponseEntity<ApiResponse> update(MacopladosForms in, String coda);
    ResponseEntity<ApiResponse> parar_acoplados(MacopladosForms2 in, String codcon);

}
