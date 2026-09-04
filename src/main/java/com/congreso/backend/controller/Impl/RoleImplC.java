package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.RoleC;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.RolMe;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.Rolper;
import com.congreso.backend.service.RolS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.congreso.backend.service.RoleS;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("role/menu/noasignados/{id_role}")
    public ResponseEntity<ApiResponse> findAll_menusSinAsignar(@PathVariable int id_role) {
        return roleS.findAll_menusSinAsignar(id_role);
    }

    @Override
    @GetMapping("role/menu/siasignados/{id_role}")
    public ResponseEntity<ApiResponse> findAll_menusAsignados(@PathVariable int id_role) {
        return roleS.findAll_menusAsignados(id_role);
    }

    @Override
    @PostMapping("role/menu/grant")
    public ResponseEntity<ApiResponse> grantRolMenu(@RequestBody RolMe rolmenu) {
        return roleS.grantRolMenu(rolmenu);
    }

    @Override
    @DeleteMapping("role/revoke/{idRol}/{idPerson}")
    public ResponseEntity<ApiResponse> revokePersons(@PathVariable int idPerson, @PathVariable int idRol) {
        return roleS.revokePersons(idPerson,idRol);
    }

    @Override
    @DeleteMapping("role/menu/revoke/{idRol}/{idMenu}")
    public ResponseEntity<ApiResponse> revokeRolMenu(@PathVariable int idRol, @PathVariable int idMenu) {
        return roleS.revokeRolMenu(idRol, idMenu);
    }

    @Override
    @PostMapping("role")
    public ResponseEntity<ApiResponse> save(@RequestBody Role role) {
        return roleS.save(role);
    }

    @Override
    @PutMapping("role/{id}")
    public ResponseEntity<ApiResponse> update(
            @RequestBody Role role,
            @PathVariable int id
    ) {
        return roleS.update(role,id);
    }

    @Override
    @DeleteMapping("role/{xid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int xid) {
        return roleS.delete(xid);
    }

/*    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('CREATE')")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return roleS.findById(id);
    }*/
}
