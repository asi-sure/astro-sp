package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.PrediosC;
import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Secciones;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class PrediosImplC implements PrediosC {
    private final PrediosS prediosS;

    @Override
    @GetMapping("predios/{estado}/{codSeccion}/{buscar}")
    public PaginatedResponse<PrediosE> findAll(
            @PathVariable int estado,
            @PathVariable int codSeccion,
            @PathVariable String buscar,
            @PageableDefault(size = 10, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable ) {
        return prediosS.findAll(estado,codSeccion,buscar,pageable);
    }

    @Override
    @GetMapping("predios/{codpre}")
    public ResponseEntity<ApiResponse> findById(@PathVariable String codpre){
        return prediosS.findById(codpre);
    }

    @Override
    @PostMapping("predios")
    public ResponseEntity<ApiResponse> save(@RequestBody Predios obj){
        return prediosS.save(obj);
    }

    @Override
    @PutMapping("predios/{codpre}")
    public ResponseEntity<ApiResponse> update(@RequestBody Predios obj,  @PathVariable String codpre){
        return prediosS.update(obj,codpre);
    }

    @Override
    @DeleteMapping("predios/{estadoactual}/{codpre}")
    public ResponseEntity<ApiResponse> delete(
            @PathVariable int estadoactual,
            @PathVariable String codpre
    ) {
        return prediosS.delete(estadoactual,codpre);
    }


} //End of the function
