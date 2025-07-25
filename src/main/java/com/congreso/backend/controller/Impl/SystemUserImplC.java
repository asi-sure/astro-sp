package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SystemUserC;
import com.congreso.backend.service.SystemsUserS;
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
@RequestMapping("/user/")
@PreAuthorize("hasAnyRole('ADMINISTRADOR','PROFESOR')")
public class SystemUserImplC implements SystemUserC {
    private final SystemsUserS systemsUserS;

//    @Override
//    @GetMapping("get")
//    @PreAuthorize("hasAuthority('CREATE')")
//    public ResponseEntity<ApiResponse> findAll() {
//        return systemsUserS.findAll();
//    }


}
