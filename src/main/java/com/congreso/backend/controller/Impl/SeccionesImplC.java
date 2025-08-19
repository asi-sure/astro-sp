package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.SeccionesC;
import com.congreso.backend.entities.Dto.SeccionesEDto;
import com.congreso.backend.entities.SeccionesE;
import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.service.SeccionesS;
import com.congreso.backend.service.SectoresS;
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
    @Override
    @GetMapping("secciones/dto/{estado}/{buscar}")
    public PaginatedResponse<SeccionesEDto> findAll_dto(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return seccionesS.findAll_dto(estado, buscar, pageable);
    }

    @Override
    @GetMapping("secciones/porsector/{estado}/{cods}")
    public ResponseEntity<ApiResponse> seccionesPorSectores(
            @PathVariable int estado,
            @PathVariable int cods ) {
        return seccionesS.listarSeccionesPorSectoresDto(estado,cods);
    }

    @Override
    @PostMapping("secciones")
    public ResponseEntity<ApiResponse> save(@RequestBody Secciones obj){
        return seccionesS.save(obj);
    }

    @Override
    @PutMapping("secciones/{codsec}")
    public ResponseEntity<ApiResponse> update(@RequestBody Secciones obj, @PathVariable int codsec) {
        return seccionesS.update(obj,codsec);
    }

    @Override
    @DeleteMapping("secciones/{estadoactual}/{codsec}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable int estadoactual,
            @PathVariable int codsec
    ) {
        return seccionesS.delete(estadoactual,codsec);
    }
}
