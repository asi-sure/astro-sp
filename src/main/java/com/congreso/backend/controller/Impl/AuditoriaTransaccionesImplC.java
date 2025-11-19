package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.AuditoriaTransaccionesC;
import com.congreso.backend.entities.AuditoriaTransaccionesE;
import com.congreso.backend.service.AuditoriaTransaccionesS;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class AuditoriaTransaccionesImplC implements AuditoriaTransaccionesC {
    private final AuditoriaTransaccionesS auditoriaTransaccionesS;

    @Override
    @GetMapping("auditoria")
    public PaginatedResponse<AuditoriaTransaccionesE> findAll(
            @RequestParam(name = "buscar", required = true) String buscar,
            @RequestParam(name = "fechaini", required = true) LocalDate fechaini,
            @RequestParam(name = "fechafin", required = true) LocalDate fechafin,
            @RequestParam(name = "tipo_operacion", required = true) String tipo_operacion,
            @PageableDefault(size = 10, sort = "momento_transaccion", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return auditoriaTransaccionesS.findAll(buscar,fechaini,fechafin,tipo_operacion,pageable);
    }
}
