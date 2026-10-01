package com.congreso.backend.controller;

import com.congreso.backend.entities.forms.GeneralResumenForms;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface GeneralC {
    ResponseEntity<ApiResponse> findAll();
    ResponseEntity<ApiResponse> findResumenGeneral();
    ResponseEntity<ApiResponse> save_generarBoletasTodos(GeneralResumenForms in);
}
