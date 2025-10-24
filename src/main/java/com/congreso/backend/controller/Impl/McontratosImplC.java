package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.McontratosC;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.model.Persons;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class McontratosImplC implements McontratosC {
    private final McontratosS mcontratosS;

    @Override
    @GetMapping("mcontratos/todo")
    public PaginatedResponse<McontratosE> findAll(
            @RequestParam(name = "estado", required = true) int estado,
            @RequestParam(name = "buscar", required = true) String buscar,
            @RequestParam(name = "fechaini", required = true) LocalDate fechaini,
            @RequestParam(name = "fechafin", required = true) LocalDate fechafin,
            @PageableDefault(size = 10, sort = "codcon", direction = Sort.Direction.ASC) Pageable pageable ) {
        return mcontratosS.findAll(estado,buscar,fechaini,fechafin,pageable);
    }
//
//    @Override
//    @GetMapping("mcontratos/boletas/todo")
//    public PaginatedResponse<McontratosE> findAll_boletasByCicli(
//            @RequestParam(name = "cicli", required = true) long cicli,
//            @PageableDefault(size = 10,direction = Sort.Direction.ASC) Pageable pageable ) {
//        return mcontratosS.findAll_boletasByCicli(cicli,pageable);
//    }

    @Override
    @GetMapping("mcontratos")
    public PaginatedResponse<McontratosEDto> findAll_2(
            @RequestParam(name = "estado", required = true) int estado,
            @RequestParam(name = "buscar", required = true) String buscar,
            @RequestParam(name = "fechaini", required = true) LocalDate fechaini,
            @RequestParam(name = "fechafin", required = true) LocalDate fechafin,
            @PageableDefault(size = 10, sort = "codcon", direction = Sort.Direction.ASC) Pageable pageable ) {
        return mcontratosS.findAll_2(estado,buscar,fechaini,fechafin,pageable);
    }

    @Override
    @PostMapping("mcontratos")
    public ResponseEntity<ApiResponse> save(@RequestBody McontratosForms in) {
        return mcontratosS.save(in);
    }

    @Override
    @DeleteMapping("mcontratos")
    public ResponseEntity<ApiResponse> delete(
            @RequestParam(name = "codcon", required = true) String codcon,
            @RequestParam(name = "idresponsable", required = true) int idresponsable
    ) {
        return mcontratosS.delete(codcon,idresponsable);
    }


}//end of class
