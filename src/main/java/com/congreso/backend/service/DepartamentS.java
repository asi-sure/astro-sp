package com.congreso.backend.service;

import com.congreso.backend.model.Departament;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface DepartamentS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Integer id);

    ResponseEntity<ApiResponse> save(Departament obj);

    ResponseEntity<ApiResponse> update(Departament obj, Integer id);

    ResponseEntity<ApiResponse> deleteById(Integer id);
}
