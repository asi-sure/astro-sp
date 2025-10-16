package com.congreso.backend.mapper;

import com.congreso.backend.entities.BoletasContratosE;
import com.congreso.backend.entities.DcontratosE;
import com.congreso.backend.entities.Dto.BoletasContratosDetalleEDto;
import com.congreso.backend.entities.Dto.BoletasContratosEDto;
import com.congreso.backend.entities.Dto.DcontratosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;

import java.util.List;
import java.util.stream.Collectors;

public class BoletasContratosMapper {
    public static BoletasContratosEDto toDto(McontratosE entity) {
        if (entity == null) {
            return null;
        }
        BoletasContratosEDto dto = new BoletasContratosEDto();
        dto.setId_inquilino(entity.getInquilino().getId());
        dto.setCedula(entity.getInquilino().getCedula());
        dto.setInquilino(entity.getInquilino().datos());
        // Map nested Set<DcontratosE> to List<DcontratosDTO>
        if (entity.getDcontratos() != null) {
            dto.setDetalle(entity.getDcontratos()
                    .stream()
                    .map(BoletasContratosMapper::mapDetalleBoletas)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    private static BoletasContratosDetalleEDto mapDetalleBoletas(DcontratosE dcontrato) {
        if (dcontrato == null) {
            return null;
        }
        BoletasContratosDetalleEDto dto = new BoletasContratosDetalleEDto();
        dto.setRubros(dcontrato.getRubros().getNombre());
//        dto.setPredios(dcontrato.getPredios().getNombre());
        // Map nested Set<DcontratosE> to List<DcontratosDTO>
//            if (dcontrato.getBoletasContratos() != null) {
//                    List<BoletasContratosDetalleEDto> boletasDtoList = dcontrato.getBoletasContratos()
//                        .stream()
//                        .map(BoletasContratosMapper::mapBoletas)
//                        .collect(Collectors.toList());
//            }
        return dto;
    }
    private static BoletasContratosDetalleEDto mapBoletas(BoletasContratosE boletas) {
//        if (dcontrato1 == null) {
//            return null;
//        }
        //here I will proccess boletas
        return null;
//        BoletasContratosDetalleEDto dto = new BoletasContratosDetalleEDto();
//        dto.setRubros(dcontrato.getRubros().getNombre());
//        dto.setPredios(dcontrato.getPredios().getNombre());
//        // Map nested Set<DcontratosE> to List<DcontratosDTO>
//        if (dcontrato.getBoletasContratos() != null) {
//            dcontrato.getBoletasContratos(dcontrato.getBoletasContratos()
//                    .stream()
//                    .map(BoletasContratosMapper::mapDetalleBoletas)
//                    .collect(Collectors.toList()));
//        }
//        return dto;
    }
}//end of class
