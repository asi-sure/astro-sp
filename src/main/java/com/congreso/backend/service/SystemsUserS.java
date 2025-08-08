package com.congreso.backend.service;

import com.congreso.backend.controller.request.AuthCreateUserRequest;
import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.model.SystemUser;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface SystemsUserS {
    ResponseEntity<ApiResponse> findAll();

    SystemUser findById(Long id);

    AuthResponse loginUser(AuthLoginRequest authLoginRequest);

    Authentication authenticate(String username, String password);

    AuthResponse createUser1(AuthCreateUserRequest authCreateUserRequest);

    ResponseEntity<ApiResponse> update(SystemUser obj);

    ResponseEntity<ApiResponse> updateChangePassword(String username, String passwd);

    SystemUser findSystemUserByEmail(String email);
}
