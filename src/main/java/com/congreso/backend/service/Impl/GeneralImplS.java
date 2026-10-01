package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.GeneralResumenDto;
import com.congreso.backend.entities.GeneralE;
import com.congreso.backend.entities.forms.GeneralResumenForms;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.model.General;
import com.congreso.backend.model.Menu;
import com.congreso.backend.model.Persons;
import com.congreso.backend.repository.PersonsR;
import com.congreso.backend.repositoryE.GeneralRepo;
import com.congreso.backend.service.GeneralS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeneralImplS implements GeneralS {
    private final GeneralRepo generalRepo;
    private final PersonsR personsR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public ResponseEntity<ApiResponse> findAll() {
        List<GeneralE> general = generalRepo.findAll();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", general);
    }
    @Override
    public ResponseEntity<ApiResponse> findResumenGeneral() {
        List<GeneralResumenDto> general = generalRepo.findResumenGeneral();
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", general);
    }

    @Override
    public ResponseEntity<ApiResponse> save_generarBoletas(GeneralResumenForms in) {
//        boolean per = personsR.si_existe_Id(in.getResponsable());
        if (!personsR.si_existe_Id(in.getResponsable())){
            throw new IllegalArgumentException("Error, El Id. de la persona no existe.");
        }

        Optional<GeneralE> general = generalRepo.findByGestionAndMeses_Id(in.getGestion(),in.getMes());
        if (general.isEmpty()){
            throw new IllegalArgumentException("Error, Los parámetros ingresados NO existen.");
        }
        int res = generalRepo.genererBoletasParaTodos(in.getResponsable(),in.getMes(),in.getGestion());
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Se Generó las boletas exitosamente.", general);
    }
}
