package com.congreso.backend.controller;

import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrivilegiosC {
    public ResponseEntity<ApiResponse> findAll();

}
