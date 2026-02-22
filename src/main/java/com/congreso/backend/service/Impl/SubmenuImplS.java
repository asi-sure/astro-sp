package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.PrivilegiosE;
import com.congreso.backend.entities.SubmenuE;
import com.congreso.backend.exception.type.ResourceNotFoundException;
import com.congreso.backend.repositoryE.PrivilegiosRepo;
import com.congreso.backend.repositoryE.SubmenuRepo;
import com.congreso.backend.service.SubmenuS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SubmenuImplS implements SubmenuS {
    private final SubmenuRepo submenuRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<SubmenuE> submenu = submenuRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Lista de Sub Menues..!", submenu);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(long id_subm) {
        Optional<SubmenuE> submenu = submenuRepo.findById(id_subm);
        if (submenu.isEmpty()) {
            throw new ResourceNotFoundException("el submenú con ID " + id_subm + " no existe.");
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Busqueda de SubMenu..!", submenu);
    }

}
