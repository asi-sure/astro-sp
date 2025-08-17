package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SectoresS {
    PaginatedResponse<SectoresE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<SectoresEDto> findAll_dto(int xestado, String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> save(Sectores obj);
    ResponseEntity<ApiResponse> update(Sectores obj, int id);
    ResponseEntity<ApiResponse> delete(int estado, int id);
}
