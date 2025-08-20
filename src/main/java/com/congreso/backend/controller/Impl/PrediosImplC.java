package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PrediosC;
import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.service.PrediosS;
import com.congreso.backend.service.SeccionesS;
import com.congreso.backend.service.SectoresS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class PrediosImplC implements PrediosC {
    private final PrediosS prediosS;

    @Override
    @GetMapping("predios/{estado}/{buscar}")
    public PaginatedResponse<PrediosE> findAll(
            @PathVariable int estado,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return prediosS.findAll(estado,buscar,pageable);
    }

    @Override
    @GetMapping("predios/porseccion/{estado}/{codsec}")
    public ResponseEntity<ApiResponse> prediosPorSector(
            @PathVariable int estado,
            @PathVariable int codsec ) {
        return prediosS.listarPrediosPorSeccion(estado,codsec);
    }

} //End of the function
