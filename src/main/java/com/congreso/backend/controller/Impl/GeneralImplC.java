package com.congreso.backend.controller.Impl;

import com.congreso.backend.controller.GeneralC;
import com.congreso.backend.entities.forms.GeneralResumenForms;
import com.congreso.backend.service.GeneralS;
import com.congreso.backend.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
//@PreAuthorize("hasRole('ADMINISTRADOR')")
public class GeneralImplC implements GeneralC {
    private final GeneralS generalS;

    @Override
    @GetMapping("general")
    public ResponseEntity<ApiResponse> findAll() {
        return generalS.findAll();
    }

    @Override
    @GetMapping("general/resumen")
    public ResponseEntity<ApiResponse> findResumenGeneral() {
        return generalS.findResumenGeneral();
    }

    @Override
    @PostMapping("general/generarboletas")
    public ResponseEntity<ApiResponse> save_generarBoletasTodos(@Valid @RequestBody GeneralResumenForms in) {
        return generalS.save_generarBoletas(in);
    }

}//endOfClass
