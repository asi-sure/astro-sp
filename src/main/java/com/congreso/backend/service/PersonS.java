package com.congreso.backend.service;

import com.congreso.backend.model.Person;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PersonS {
    ResponseEntity<ApiResponse> findAll();

    ResponseEntity<ApiResponse> getById(Long id);
    Person getById2(Long id);

    ResponseEntity<ApiResponse> save(Person person);

    ResponseEntity<ApiResponse> update(Person person, Long id);

    ResponseEntity<ApiResponse> deleteById(Long id);
}
