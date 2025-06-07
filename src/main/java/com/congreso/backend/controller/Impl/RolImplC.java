package com.congreso.backend.controller.Impl;

import com.congreso.backend.model.Rol;
import com.congreso.backend.service.RolS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rol/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class RolImplC {
    private final RolS rolS;

/*    @GetMapping("findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return rolS.findAll();
    }*/

/*    @GetMapping("findById/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> findById(@PathVariable int id) {
        return rolS.findById(id);
    }*/

/*    @PostMapping("save")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> save(@RequestBody Rol rol) {
        return rolS.save(rol);
    }*/

/*    @PutMapping("deleteById")
    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> deleteById(@RequestParam int id) {
        return rolS.deleteById(id);
    }*/
}
