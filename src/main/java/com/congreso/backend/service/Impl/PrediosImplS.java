package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.PrediosE;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.Role;
import com.congreso.backend.repository.PrediosR;
import com.congreso.backend.repositoryE.PrediosRepo;
import com.congreso.backend.service.PrediosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PrediosImplS implements PrediosS {
    private final PrediosRepo prediosRepo;
    private final PrediosR prediosR;
    private final CustomResponseBuilder customResponseBuilder;

    @Override
    public PaginatedResponse<PrediosE> findAll(int xestado,int codsec,String buscar, Pageable pageable) {
        int xcod1=0; int xcod2=99999;
        if (codsec != 0) { xcod1=codsec; xcod2=codsec; }
        Page<PrediosE> page = prediosRepo.listarPredios(xestado,xcod1,xcod2,"%"+buscar.trim()+"%", pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public ResponseEntity<ApiResponse> findById(String codpre) {
        Predios predios = prediosR.findById(codpre);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", predios,null);
    }

    @Override
    public ResponseEntity<ApiResponse> save(Predios obj) {
        if (prediosR.verificarNombre(obj.getNombre(),"0")) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Predio ya Existe.", 0);
        }
        try {
            String id = prediosR.save(obj);//guarda inquilin
        } catch (Exception e) {
            e.printStackTrace();
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Guardar los Datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }

    @Override
    public ResponseEntity<ApiResponse> update(Predios obj, String id) {
        if (prediosR.verificarNombre(obj.getNombre(),id)) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "El Predio ya Existe.", 0);
        }
        boolean updated = prediosR.update(obj, id);//MODIFICA DATOS
        if (!updated) {
            return customResponseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error al Modificar los datos.", 0);
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Actualizacion exitosa.", updated);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(int estado,String id) {
        if (estado!=0 && estado!=1) {//si estado es diferente a 1 o 0
            return customResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), "El valor ESTADO ACTUAL no es válido. Por favor, revise la información.", 0);
        }
        boolean status = prediosR.delete(estado, id);
        String mensaje="";
        if (estado==1) {
            mensaje="Se eliminó satisfactoriamente.";
        }else{
            mensaje="Se habilitó satisfactoriamente.";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }

//    @Override
//    public ResponseEntity<ApiResponse> listarPrediosPorSeccion(int estado, int codsec) {
//        List<PrediosE> predios = prediosRepo.listarPrediosPorSecciones(estado,codsec);
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", predios);
//    }




} //End of the function
