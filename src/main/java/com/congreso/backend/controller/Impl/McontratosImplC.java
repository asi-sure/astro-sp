package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.McontratosC;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class McontratosImplC implements McontratosC {
    private final McontratosS mcontratosS;

    @Override
    @GetMapping("mcontratos/{estado}")
    public PaginatedResponse<McontratosE> findAll(
            @PathVariable int estado,
            Pageable pageable ) {
        //return inquilinosS.findAll(estado,buscar,pageable);
        return mcontratosS.findAll(estado,pageable);
    }

    /*
        @Override
    @GetMapping("inquilinos/{estado}/{buscar}")
    public PaginatedResponse<InquilinosE> findAll(
            @PathVariable boolean estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return inquilinosS.findAll(estado,buscar,pageable);
    }
     */
}
