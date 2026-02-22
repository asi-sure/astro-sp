package com.congreso.backend.service;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface SubmenuS {
    ResponseEntity<ApiResponse> findAll();
    ResponseEntity<ApiResponse> findById(long id_subm);
}
