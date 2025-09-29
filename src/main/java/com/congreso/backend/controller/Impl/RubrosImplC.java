package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.RubrosC;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.model.forms.RubrosForm;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.service.RubrosS;
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
public class RubrosImplC implements RubrosC {
    private final RubrosS rubrosS;

    @Override
    @GetMapping("rubros/{estado}/{buscar}")
    public PaginatedResponse<RubrosE> findAll(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return rubrosS.findAll(estado,buscar,pageable);
    }

    @Override
    @GetMapping("rubros/{codpadre}/{estado}/{buscar}")
    public PaginatedResponse<RubrosForm> findAllByPadre(
            @PathVariable String codpadre,
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return rubrosS.findAllByPadre(codpadre,estado,buscar,pageable);
    }

    @Override
    @GetMapping("rubros/{codc}")
    public ResponseEntity<ApiResponse> findByCodc_C(@PathVariable String codc) {
        return rubrosS.findByCodc(codc);
    }
    @Override
    @GetMapping("/padres/rubros")
    public ResponseEntity<ApiResponse> findSoloPadre() {
        return rubrosS.findSoloPadre();
    }

    @Override
    @GetMapping("/rubros/hijos")
    public ResponseEntity<ApiResponse> findSoloHijos() {
        return rubrosS.findSoloHijos();
    }

    @Override
    @PostMapping("rubros")
    public ResponseEntity<ApiResponse> save(
            @RequestBody RubrosForm obj) {
        return rubrosS.save(obj);
    }

    @Override
    @PutMapping("rubros/{codc}")
    public ResponseEntity<ApiResponse> update(
            @RequestBody RubrosForm obj,
            @PathVariable String codc
    ) {
        return rubrosS.update(obj,codc);
    }

    @Override
    @DeleteMapping("rubros/{codc}")
    public ResponseEntity<ApiResponse> delete(@PathVariable String codc) {
        return rubrosS.delete(codc);
    }

} //end of class
