package com.congreso.backend.service;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface InquilinosS {
    ResponseEntity<ApiResponse> findAll(boolean xestado);
    ResponseEntity<ApiResponse> save(InquilinosForm obj, MultipartFile file);
    ResponseEntity<ApiResponse> update(InquilinosForm obj, MultipartFile file, int id);
    ResponseEntity<ApiResponse> delete(int id);
}
