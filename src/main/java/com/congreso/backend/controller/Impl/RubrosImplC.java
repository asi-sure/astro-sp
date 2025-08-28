package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.RubrosC;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.service.InquilinosS;
import com.congreso.backend.service.RubrosS;
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
}
