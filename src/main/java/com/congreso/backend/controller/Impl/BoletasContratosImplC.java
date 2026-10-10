package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.BoletasContratosC;
import com.congreso.backend.entities.Dto.BoletasContratosE2Dto;
import com.congreso.backend.service.BoletasContratosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class BoletasContratosImplC implements BoletasContratosC {
    //private final InquilinosS inquilinosS;
    private final BoletasContratosS boletasContratosS;

    @Override
    @GetMapping("boletas_contratos/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        return boletasContratosS.obtenerDetalleInquilino(id);
    }

    @Override
    @GetMapping("boletas_contratos/allboletas")
    public PaginatedResponse<BoletasContratosE2Dto> obtenerBoletasByCondon(
            @RequestParam(name = "codcon", required = true) String codcon,
            @PageableDefault(size = 10, sort = "mcontratos.codcon", direction = Sort.Direction.ASC) Pageable pageable) {
        return boletasContratosS.obtenerBoletasBycodcon(codcon, pageable);
    }

    @Override
    @GetMapping("boletas_contratos/inquilinos")
    public ResponseEntity<ApiResponse> obtenerListaInquilinos() {
        return boletasContratosS.obtenerListaDeInquilino();
    }

}
