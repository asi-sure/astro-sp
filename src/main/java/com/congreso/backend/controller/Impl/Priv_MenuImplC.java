package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.Priv_MenuC;
import com.congreso.backend.service.Priv_MenuS;
import com.congreso.backend.service.PrivilegiosS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class Priv_MenuImplC implements Priv_MenuC {
    private final Priv_MenuS priv_menuS;

    @Override
    @GetMapping("privilegios/menu")
    public ResponseEntity<ApiResponse> findAll() {
        return priv_menuS.findAll();
    }
}
