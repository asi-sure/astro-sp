package com.congreso.backend.controller;

import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface SectoresC {
    PaginatedResponse<SectoresE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<SectoresEDto> findAll_dto(int xestado, String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> save(Sectores obj);
}
