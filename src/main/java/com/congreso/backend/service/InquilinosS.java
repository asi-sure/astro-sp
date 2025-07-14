package com.congreso.backend.service;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface InquilinosS {
    ResponseEntity<ApiResponse> findAll(boolean xestado);
}
