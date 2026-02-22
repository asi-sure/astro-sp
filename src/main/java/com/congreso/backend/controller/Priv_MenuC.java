package com.congreso.backend.controller;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface Priv_MenuC {
    public ResponseEntity<ApiResponse> findAll();
}
