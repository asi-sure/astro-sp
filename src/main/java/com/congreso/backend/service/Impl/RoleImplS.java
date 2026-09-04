package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.MenuE;
import com.congreso.backend.entities.RoleE;
import com.congreso.backend.exception.type.ResourceNotFoundException;
import com.congreso.backend.model.RolMe;
import com.congreso.backend.model.Rolper;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.repository.RoleR;
import com.congreso.backend.repositoryE.MenuRepo;
import com.congreso.backend.repositoryE.RoleRepo;
import com.congreso.backend.service.RoleS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.congreso.backend.model.Role;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleImplS implements RoleS {
    private final RoleR roleR;
    private final RoleRepo roleRepo;
    private final MenuRepo menuRepo;

    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll(boolean xstatus) {
        List<Role> roles = roleR.findAll(xstatus);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", roles);
    }
    @Override
    public ResponseEntity<ApiResponse> findById(Long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }

    @Override
    public ResponseEntity<ApiResponse> grantPersons(Rolper role) {
        Long id = roleR.grantPersons(role);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> grantRolMenu(RolMe rolmenu) {
        RoleE xrole = roleRepo.findById(rolmenu.getId_role())
                .orElseThrow(() -> new ResourceNotFoundException("El ID. rol","ID. rol",rolmenu.getId_role()));
        MenuE smenu = menuRepo.findById(rolmenu.getId_menu())
                .orElseThrow(() -> new ResourceNotFoundException("El ID. menu","ID. menu",rolmenu.getId_menu()));

        Long id = roleR.grantRolMenu(rolmenu);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> revokePersons(int idPerson, int idRol) {

        Boolean res = roleR.revokePersons(idPerson, idRol);
        if (!res){
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "No existen datos para eliminar", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> revokeRolMenu(int idRol, int idMenu) {
        RoleE xrole = roleRepo.findById(idRol)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. rol","ID. rol",idRol));
        MenuE smenu = menuRepo.findById(idMenu)
                .orElseThrow(() -> new ResourceNotFoundException("El ID. menu","ID. menu",idMenu));

        Boolean res = roleR.revokeRolMenu(idRol, idMenu);
        if (!res){
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "No existen datos para eliminar", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", 0);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Role role) {
        try {
            Long idrol = roleR.save(role);
        } catch (Exception e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al guardar Datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(int id) {
        boolean status = roleR.delete(id);
        String mensaje="";
        if (status) {
            mensaje="Se habilitó satisfactoriamente.";
        }else{
            mensaje="Se eliminó satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }

    @Override
    public ResponseEntity<ApiResponse> update(Role obj, int id) {
        boolean updated = roleR.update(obj, id);
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar los datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }

/*    @Override
    public ResponseEntity<ApiResponse> findById(long id) {
        Role role = roleR.getById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", role);
    }*/


}
