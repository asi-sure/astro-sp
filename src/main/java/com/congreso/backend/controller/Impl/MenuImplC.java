package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.MenuC;
import com.congreso.backend.service.DepartamentS;
import com.congreso.backend.service.MenuS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class MenuImplC implements MenuC {
    private final MenuS menuS;

/*    @Override
    @GetMapping("")
    public ResponseEntity<ApiResponse> findAll() {
        return menuS.findAll();
    }*/
}
