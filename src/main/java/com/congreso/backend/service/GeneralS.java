package com.congreso.backend.service;

import com.congreso.backend.entities.forms.GeneralResumenForms;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface GeneralS {
    ResponseEntity<ApiResponse> findAll();
    ResponseEntity<ApiResponse> findResumenGeneral();
    ResponseEntity<ApiResponse> save_generarBoletas(GeneralResumenForms in);
}
