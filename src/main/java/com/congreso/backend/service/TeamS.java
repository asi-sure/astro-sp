package com.congreso.backend.service;

import com.congreso.backend.model.Team;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface TeamS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> findById(Integer id);

    ResponseEntity<ApiResponse> save(Team team);

    ResponseEntity<ApiResponse> update(Team obj, Integer id);

    ResponseEntity<ApiResponse> deleteById(Integer id);
}
