package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.InquilinosC;
import com.congreso.backend.model.Inquilinos;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class InquilinosImplC implements InquilinosC {
    private final InquilinosS inquilinosS;

    @Override
    @GetMapping("inquilinos/{xestado}")
    public ResponseEntity<ApiResponse> findAll(@PathVariable boolean xestado) {
        return inquilinosS.findAll(xestado);
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
    @DeleteMapping("inquilinos/{xid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int xid) {
        return inquilinosS.delete(xid);
    }

    /*
    @DeleteMapping("persons/{xid}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int xid) {
        return personsS.delete(xid);
    }
    * */

} //the end
