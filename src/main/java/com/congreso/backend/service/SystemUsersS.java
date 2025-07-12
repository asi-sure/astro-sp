package com.congreso.backend.service;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.SystemUsers;
import com.congreso.backend.model.dto.SystemUsersDto;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SystemUsersS {
    ResponseEntity<ApiResponse> save(SystemUsersDto user);
}
