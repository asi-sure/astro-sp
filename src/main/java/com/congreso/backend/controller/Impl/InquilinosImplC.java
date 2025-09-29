package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.InquilinosC;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.model.Inquilinos_ubic;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class InquilinosImplC implements InquilinosC {
    private final InquilinosS inquilinosS;
    @Override
    @GetMapping("inquilinos/{estado}/{buscar}")
    public PaginatedResponse<InquilinosE> findAll(
            @PathVariable boolean estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return inquilinosS.findAll(estado,buscar,pageable);
    }
    @Override
    @GetMapping("inquilinos/id/{xid}")
    public ResponseEntity<ApiResponse> findById(@PathVariable int xid) {
        return inquilinosS.findById(xid);
    }
    @Override
    @GetMapping("inquilinos/{status}")
    public ResponseEntity<ApiResponse> findAll_3(@PathVariable boolean status) {
        return inquilinosS.findAll_3(status);
    }

    @Override
    @PostMapping("inquilinos")
    public ResponseEntity<ApiResponse> save(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file) {
        return inquilinosS.save(obj, file);
    }
    @Override
    @PutMapping("inquilinos/{id}")
    public ResponseEntity<ApiResponse> update(
            @RequestPart("inquilinos") InquilinosForm obj,
            @RequestPart("file") MultipartFile file,
            @PathVariable int id
    ) {
        return inquilinosS.update(obj, file, id);
    }
    @Override
    @PutMapping("inquilinos/gps8/{id}")
    public ResponseEntity<ApiResponse> updateGPS(
            @RequestPart("inquilinos") Inquilinos_ubic obj,
            @PathVariable int id
    ) {
        return inquilinosS.updateGPS(obj, id);
    }

    @Override
    @PutMapping("inquilinos/img/{id}")
    public ResponseEntity<ApiResponse> updateUrlUbicacion(
            @RequestPart("file") MultipartFile file,
            @PathVariable int id
    ) {
        return inquilinosS.updateUrlUbicacion(file,id);
    }

    @Override
    @DeleteMapping("inquilinos/{xid}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable int xid
    ) {
        return inquilinosS.delete(xid);
    }

} //the end
