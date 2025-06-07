package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PermissionC;
import com.congreso.backend.model.Permission;
import com.congreso.backend.service.PermissionS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permission/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class PermissionImplC implements PermissionC {
    private final PermissionS permissionS;

/*    @Override
    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return permissionS.findAll();
    }*/

/*    @Override
    @GetMapping("findById/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> findById(@PathVariable int id) {
        return permissionS.findById(id);
    }*/

/*    @Override
    @PostMapping("save")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> save(@RequestBody Permission permission) {
        return permissionS.save(permission);
    }*/

/*    @Override
    @PutMapping("update/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> update(@PathVariable int id, @RequestBody Permission permission) {
        return permissionS.update(permission, id);
    }*/

/*    @Override
    @PutMapping("deleteById/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable int id) {
        return permissionS.deleteById(id);
    }*/

}
