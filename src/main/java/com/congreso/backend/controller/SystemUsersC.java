package com.congreso.backend.controller;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface SystemUsersC {
    ResponseEntity<ApiResponse> save(@RequestBody SystemUsersDto user);
}
