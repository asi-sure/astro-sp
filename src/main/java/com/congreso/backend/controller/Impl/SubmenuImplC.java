package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SubmenuC;
import com.congreso.backend.service.PrivilegiosS;
import com.congreso.backend.service.SubmenuS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SubmenuImplC implements SubmenuC {
    private final SubmenuS submenuS;

    @Override
    @GetMapping("submenu")
    public ResponseEntity<ApiResponse> findAll() {
        return submenuS.findAll();
    }

    @Override
    @GetMapping("submenu/{id_subm}")
    public ResponseEntity<ApiResponse> findById(@PathVariable long id_subm) {
        return submenuS.findById(id_subm);
    }
}
