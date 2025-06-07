package com.congreso.backend.service;

import com.congreso.backend.model.Region;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface RegionS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Integer id);

    ResponseEntity<ApiResponse> save(Region obj);

    ResponseEntity<ApiResponse> update(Region obj, Integer id);

    ResponseEntity<ApiResponse> deleteById(Integer id);
}
