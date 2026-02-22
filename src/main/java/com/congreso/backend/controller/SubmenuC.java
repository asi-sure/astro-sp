package com.congreso.backend.controller;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface SubmenuC {

    public ResponseEntity<ApiResponse> findAll();
    public ResponseEntity<ApiResponse> findById(long id_subm);

}
