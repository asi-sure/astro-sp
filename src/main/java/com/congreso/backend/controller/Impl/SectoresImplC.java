package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SectoresC;
import com.congreso.backend.entities.SectoresE;
import com.congreso.backend.service.SectoresS;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
