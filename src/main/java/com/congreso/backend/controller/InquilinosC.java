package com.congreso.backend.controller;

import com.congreso.backend.model.Inquilinos;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface InquilinosC {
    ResponseEntity<ApiResponse> findAll(boolean xestado);
    ResponseEntity<ApiResponse> save(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file);
    ResponseEntity<ApiResponse> update(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file,
            @PathVariable int id);


} //the end
