package com.congreso.backend.service;

import com.congreso.backend.model.Permission;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PermissionS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Integer id);

    ResponseEntity<ApiResponse> save(Permission permission);

    ResponseEntity<ApiResponse> update(Permission obj, Integer id);

    ResponseEntity<ApiResponse> deleteById(Integer id);
}
