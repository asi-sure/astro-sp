package com.congreso.backend.controller;

import com.congreso.backend.controller.request.AuthCreateUserRequest;
import com.congreso.backend.controller.request.AuthLoginRequest;
import com.congreso.backend.model.dto.MenusDto;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AuthenticacionC {
/*    @PostMapping("sign-up")
    ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUser);*/

    @PostMapping("log-in")
    ResponseEntity<ApiResponse> login(@RequestBody @Valid AuthLoginRequest userRequest);

    public List<MenusDto> obtenerMenuSubmenu(Long id_person);
/*    @PostMapping("log-in")
    ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest);*/

}
