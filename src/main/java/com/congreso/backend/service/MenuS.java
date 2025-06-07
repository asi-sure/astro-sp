package com.congreso.backend.service;

import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface MenuS {

    ResponseEntity<ApiResponse> findAll();

}
