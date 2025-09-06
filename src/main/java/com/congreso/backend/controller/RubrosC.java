package com.congreso.backend.controller;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.model.forms.RubrosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface RubrosC {
    PaginatedResponse<RubrosE> findAll(int xestado, String buscar, Pageable pageable);
    PaginatedResponse<RubrosForm> findAllByPadre(String codpadre, int xestado, String buscar, Pageable pageable);
    ResponseEntity<ApiResponse> findByCodc_C(String codc);
    ResponseEntity<ApiResponse> findSoloPadre();
    ResponseEntity<ApiResponse> save(RubrosForm obj);
    ResponseEntity<ApiResponse> update(RubrosForm obj, String codc);
    ResponseEntity<ApiResponse> delete(String codc);
}
