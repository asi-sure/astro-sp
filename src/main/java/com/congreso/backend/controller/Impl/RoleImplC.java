package com.congreso.backend.controller.Impl;

import com.congreso.backend.service.RolS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.congreso.backend.service.RoleS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class RoleImplC {

    private final RoleS roleS;

/*    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return roleS.findById(id);
    }*/
}
