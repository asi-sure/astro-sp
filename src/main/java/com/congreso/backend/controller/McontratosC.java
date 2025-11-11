package com.congreso.backend.controller;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.entities.forms.McontratosForms2;
import com.congreso.backend.model.Persons;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public interface McontratosC {
    PaginatedResponse<McontratosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin,int stop, Pageable pageable);
//    PaginatedResponse<McontratosE> findAll_boletasByCicli(long cicli, Pageable pageable);
    PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin,int stop, Pageable pageable);
    ResponseEntity<ApiResponse> save(McontratosForms in);
    ResponseEntity<ApiResponse> delete(String codcon, int idresponsable);
    ResponseEntity<ApiResponse> update(McontratosForms2 in, String codcon);
    ResponseEntity<ApiResponse> parar_contratos(McontratosForms2 in, String codcon);

} //end of class
