package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.MacopladosC;
import com.congreso.backend.entities.Dto.MacopladosEDto;
import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.entities.forms.MacopladosForms2;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.entities.forms.McontratosForms2;
import com.congreso.backend.service.MacopladosS;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class MacopladosImplC implements MacopladosC {
    private final MacopladosS macopladosS;

    @Override
    @GetMapping("macoplados/todo")
    public PaginatedResponse<MacopladosE> findAll(
            @RequestParam(name = "estado", required = true) int estado,
            @RequestParam(name = "buscar", required = true) String buscar,
            @RequestParam(name = "fechaini", required = true) LocalDate fechaini,
            @RequestParam(name = "fechafin", required = true) LocalDate fechafin,
            @RequestParam(name = "stop", required = true) int stop,
            @PageableDefault(size = 10, sort = "coda", direction = Sort.Direction.ASC) Pageable pageable ) {
        return macopladosS.findAll(estado,buscar,fechaini,fechafin,stop,pageable);
    }
    @Override
    @GetMapping("macoplados")
    public PaginatedResponse<MacopladosEDto> findAll_2(
            @RequestParam(name = "estado", required = true) int estado,
            @RequestParam(name = "buscar", required = true) String buscar,
            @RequestParam(name = "fechaini", required = true) LocalDate fechaini,
            @RequestParam(name = "fechafin", required = true) LocalDate fechafin,
            @RequestParam(name = "stop", required = true) int stop,
            @PageableDefault(size = 10, sort = "coda", direction = Sort.Direction.ASC) Pageable pageable ) {
        return macopladosS.findAll_2(estado,buscar,fechaini,fechafin,stop,pageable);
    }
    @Override
    @GetMapping("macoplados/data")
    public ResponseEntity<ApiResponse> findByCoda(
            @RequestParam(name = "coda", required = true) String xcoda) {
        return macopladosS.findByCoda(xcoda);
    }

    @Override
    @PostMapping("macoplados")
    public ResponseEntity<ApiResponse> save(@RequestBody MacopladosForms in) {
        return macopladosS.save(in);
    }
    @Override
    @DeleteMapping("macoplados")
    public ResponseEntity<ApiResponse> delete(
            @RequestParam(name = "coda", required = true) String coda,
            @RequestParam(name = "idresponsable", required = true) int idresponsable
    ) {
        return macopladosS.delete(coda,idresponsable);
    }

    @Override
    @PutMapping("macoplados")
    public ResponseEntity<ApiResponse> update(
            @RequestBody MacopladosForms in,
            @RequestParam(name = "coda", required = true) String coda
    ) {
        return macopladosS.update(in,coda);
    }

    @Override
    @PutMapping("macoplados/stop")
    public ResponseEntity<ApiResponse> parar_acoplados(
            @RequestBody MacopladosForms2 in,
            @RequestParam(name = "coda", required = true) String coda
    ) {
        return macopladosS.parar_acoplados(in,coda);
    }

} //end of class
