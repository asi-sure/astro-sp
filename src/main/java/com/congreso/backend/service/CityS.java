package com.congreso.backend.service;

import com.congreso.backend.model.City;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface CityS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Long id);

    ResponseEntity<ApiResponse> save(City city);

    ResponseEntity<ApiResponse> update(City city, Long id);

    ResponseEntity<ApiResponse> deleteById(Long id);
}
