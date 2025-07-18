package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.RoleC;
import com.congreso.backend.model.Rolper;
import com.congreso.backend.service.RolS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.congreso.backend.service.RoleS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class RoleImplC implements RoleC {

    private final RoleS roleS;

    @Override
    @GetMapping("role/{xstatus}")
    public ResponseEntity<ApiResponse> findAll(@PathVariable boolean xstatus) {
        return roleS.findAll(xstatus);
    }

    @Override
    @PostMapping("role/grant")
    public ResponseEntity<ApiResponse> grantPersons(@RequestBody Rolper role) {
        return roleS.grantPersons(role);
    }

    @Override
    @DeleteMapping("role/revoke/{idRol}/{idPerson}")
    public ResponseEntity<ApiResponse> revokePersons(@PathVariable int idPerson, @PathVariable int idRol) {
        return roleS.revokePersons(idPerson,idRol);
    }


/*    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return roleS.findById(id);
    }*/
}
