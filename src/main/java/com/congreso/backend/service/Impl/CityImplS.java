package com.congreso.backend.service.Impl;

import com.congreso.backend.model.City;
import com.congreso.backend.repository.CityR;
import com.congreso.backend.service.CityS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CityImplS implements CityS {
    private final CityR cityR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<City> cities = cityR.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitoso.", cities);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(Long id) {
        City city = cityR.findById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitoso.", city);
    }

    @Override
    public ResponseEntity<ApiResponse> save(City city) {
        try {
            boolean result = cityR.save(city);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Registro exitoso.", result);
        } catch (Exception e) {
            log.error("save error", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al registrar el registro.", null);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> update(City city, Long id) {
        try {
            boolean result = cityR.update(city, id);
            return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitoso.", result);
        } catch (Exception e) {
            log.error("update error", e);
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al actualizar el registro.", null);
        }

    }

    @Override
    public ResponseEntity<ApiResponse> deleteById(Long id) {
        boolean result = cityR.deleteById(id);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Eliminacion exitoso.", result);
    }
}
