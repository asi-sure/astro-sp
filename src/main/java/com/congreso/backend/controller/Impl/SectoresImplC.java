package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SectoresC;
import com.congreso.backend.entities.Dto.SectoresEDto;
import com.congreso.backend.entities.JsonViews;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.service.SectoresS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SectoresImplC implements SectoresC {
//private final InquilinosS inquilinosS;
    private final SectoresS sectoresS;

    @Override
    @GetMapping("sectores/{estado}/{buscar}")
    public PaginatedResponse<SectoresE> findAll(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return sectoresS.findAll(estado, buscar, pageable);
    }

    @Override
    @GetMapping("sectores/dto/{estado}/{buscar}")
    public PaginatedResponse<SectoresEDto> findAll_dto(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return sectoresS.findAll_dto(estado, buscar, pageable);
    }
    @Override
    @PostMapping("sectores")
    public ResponseEntity<ApiResponse> save(@RequestBody Sectores obj) {
        return sectoresS.save(obj);
    }

}
