package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SeccionesC;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.service.SeccionesS;
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
public class SeccionesImplC implements SeccionesC {
    private final SeccionesS seccionesS;

    @Override
    @GetMapping("secciones/{estado}/{buscar}")
    public PaginatedResponse<SeccionesE> findAll(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return seccionesS.findAll(estado, buscar, pageable);
    }
}
