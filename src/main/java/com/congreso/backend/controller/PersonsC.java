package com.congreso.backend.controller;

import com.congreso.backend.model.Persons;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface PersonsC {

    ResponseEntity<ApiResponse> findAll(boolean xstatus);
    ResponseEntity<ApiResponse> findById(int id);
    ResponseEntity<ApiResponse> delete(int id);
    ResponseEntity<ApiResponse> save(
            @RequestPart("person") Persons person,
            @RequestPart("file") MultipartFile file);
    ResponseEntity<ApiResponse> update(
            @RequestPart("person") Persons person,
            @RequestPart("file") MultipartFile file,
            @PathVariable int id);
//    String upload(@RequestParam("file") MultipartFile file);


}
