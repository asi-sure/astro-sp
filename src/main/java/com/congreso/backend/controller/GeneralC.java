package com.congreso.backend.controller;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface GeneralC {
    ResponseEntity<ApiResponse> findAll();
}
