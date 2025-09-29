package com.congreso.backend.service;

import com.congreso.backend.entities.Dto.InquilinosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.model.Inquilinos_ubic;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InquilinosS {
    PaginatedResponse<InquilinosE> findAll(boolean xestado,String buscar, Pageable pageable);
    PaginatedResponse<InquilinosEDto> findAll_2(boolean xestado,String buscar, Pageable pageable); //ejemplo usando DTO
    ResponseEntity<ApiResponse> findAll_3(boolean xestado); //listar todos los inquilinos.
    ResponseEntity<ApiResponse> findById(int id);
    ResponseEntity<ApiResponse> save(InquilinosForm obj, MultipartFile file);
    ResponseEntity<ApiResponse> update(InquilinosForm obj, MultipartFile file, int id);
    ResponseEntity<ApiResponse> updateGPS(Inquilinos_ubic obj, int id);
    ResponseEntity<ApiResponse> updateUrlUbicacion(MultipartFile file, int id);
    ResponseEntity<ApiResponse> delete(int id);
}
