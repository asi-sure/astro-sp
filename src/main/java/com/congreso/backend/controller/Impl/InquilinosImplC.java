package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.InquilinosC;
import com.congreso.backend.entities.Dto.InquilinosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.model.Inquilinos;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.service.PersonsS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class InquilinosImplC implements InquilinosC {
    private final InquilinosS inquilinosS;
    @Override
    @GetMapping("inquilinos/{estado}")
    public PaginatedResponse<InquilinosE> findAll(
            @PathVariable boolean estado,
            Pageable pageable ) {
        return inquilinosS.findAll(estado,pageable);
    }
    @Override
    @GetMapping("inquilinos/id/{xid}")
    public ResponseEntity<ApiResponse> findById(@PathVariable int xid) {
        return inquilinosS.findById(xid);
    }

//    @Override
//    @GetMapping("inquilinos2/{estado}")
//    public PaginatedResponse<InquilinosEDto> findAll_2(
//            @PathVariable boolean estado,
//            Pageable pageable ) {
//        return inquilinosS.findAll_2(estado,pageable);
//    }

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
