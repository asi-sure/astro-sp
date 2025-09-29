package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.RubrosE;
import com.congreso.backend.model.Inquilinos_ubic;
import com.congreso.backend.model.forms.RubrosForm;
import com.congreso.backend.repository.InquilinosR;
import com.congreso.backend.repository.RubrosR;
import com.congreso.backend.repositoryE.InquilinosRepo;
import com.congreso.backend.repositoryE.RubrosRepo;
import com.congreso.backend.service.RubrosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RubrosImplS implements RubrosS {
    private final RubrosR rubrosR;
    private final RubrosRepo rubrosRepo;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<RubrosE> findAll(int xestado, String buscar, Pageable pageable) {
        Page<RubrosE> page = rubrosRepo.listarRubros(xestado,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public PaginatedResponse<RubrosForm> findAllByPadre(String codpadre, int xestado, String buscar, Pageable pageable) {
        Page<Object[]> page = rubrosRepo.listarRubrosByPadre(codpadre, xestado,"%"+buscar.trim()+"%", pageable);

        List<RubrosForm> forms = page.getContent().stream()
                .map(tuple -> new RubrosForm((String) tuple[0], (String) tuple[1], (int) tuple[2], (String) tuple[3]))
                .collect(Collectors.toList());
        // You would then have to re-create the Page object
        Page<RubrosForm> pageOfForms = new PageImpl<>(forms, pageable, page.getTotalElements());

        return PaginationUtils.toPaginatedResponse(pageOfForms);
    }
    @Override
    public ResponseEntity<ApiResponse> findByCodc(String codc) {
        RubrosForm rubros = rubrosR.findByCodc(codc);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", rubros,null);
    }
    @Override
    public ResponseEntity<ApiResponse> findSoloPadre() {
        List<RubrosForm> rubros = rubrosR.findSoloPadre();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", rubros,null);
    }

    @Override
    public ResponseEntity<ApiResponse> findSoloHijos() {
        List<RubrosForm> rubros = rubrosR.findSoloHijos();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", rubros,null);
    }

    @Override
    public ResponseEntity<ApiResponse> save(RubrosForm obj) {
        if (rubrosR.verificarKey(obj.getCodc())) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Código Rubro ya Existe.", 0);
        }
        if (rubrosR.verificarNombre("0",obj.getNombre())) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Nombre del Rubro ya Existe.", 0);
        }
        String id = rubrosR.save(obj);//guarda rubros
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }

    @Override
    public ResponseEntity<ApiResponse> update(RubrosForm obj, String codc) {
        if (rubrosR.verificarNombre(codc, obj.getNombre())) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Nombre del Rubro ya Existe.", 0);
        }
        boolean updated = rubrosR.update(obj,codc);  //updating
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Modificar los datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(String codc) {
        int status = rubrosR.delete(codc);
        String mensaje="";
        if (status == 2) {
            mensaje="Cuenta PADRE tiene HIJOS activos";
        }else {
            if (status==1) {
                mensaje = "Se habilitó satisfactoriamente.";
            } else {
                mensaje = "Se eliminó satisfactoriamente.";
            }
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }

} // end of class
