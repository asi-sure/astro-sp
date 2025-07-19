package com.congreso.backend.controller;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.model.Inquilinos;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface InquilinosC {
    PaginatedResponse<InquilinosE> findAll(boolean xestado, Pageable pageable);
    ResponseEntity<ApiResponse> save(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file);
    ResponseEntity<ApiResponse> update(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file,
            @PathVariable int id);
    ResponseEntity<ApiResponse> delete(int id);

} //the end
