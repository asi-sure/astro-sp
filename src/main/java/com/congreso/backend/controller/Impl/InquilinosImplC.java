package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.InquilinosC;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class InquilinosImplC implements InquilinosC {
    private final InquilinosS inquilinosS;

    @Override
    @GetMapping("inquilinos/{xestado}")
    public ResponseEntity<ApiResponse> findAll(@PathVariable boolean xestado) {
        return inquilinosS.findAll(xestado);
    }

}
