package com.congreso.backend.controller;

import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Persons;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface MenuC {

    ResponseEntity<ApiResponse> findAll_2(@PathVariable boolean xstatus);
    ResponseEntity<ApiResponse> save(@RequestBody Menu menu);
}
