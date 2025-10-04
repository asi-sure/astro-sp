package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public interface McontratosS {
    PaginatedResponse<McontratosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable);
    PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable);
    ResponseEntity<ApiResponse> save(McontratosForms in);
}
