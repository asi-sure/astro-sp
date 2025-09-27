package com.congreso.backend.mapper;

import com.congreso.backend.entities.DcontratosE;
import com.congreso.backend.entities.Dto.DcontratosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.McontratosE;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class McontratosMapper {
    public static McontratosEDto toDto(McontratosE entity) {
        if (entity == null) {
            return null;
        }

        McontratosEDto dto = new McontratosEDto();
        dto.setCodcon(entity.getCodcon());
        dto.setGestion(entity.getGestion());
        dto.setFechaini(entity.getFechaini());
        dto.setFechafin(entity.getFechafin());
        dto.setEstado(entity.getEstado());
        dto.setMonto(entity.getMonto());
        dto.setObs(entity.getObs());
        dto.setContador(entity.getContador());
        dto.setCf(entity.getCf());
        dto.setFecha(entity.getFecha());
        dto.setStop(entity.getStop());
        dto.setFechareg(entity.getFechareg());

        // Map related entities to their DTOs
        if (entity.getInquilino() != null) {
            String xap="", xam="";
            if (entity.getInquilino().getAp() != null) { xap=entity.getInquilino().getAp();}
            if (entity.getInquilino().getAm() != null) { xam=entity.getInquilino().getAm();}
            dto.setInquilino(entity.getInquilino().getNombre()+" "+xap+" "+xam);
        }
        if (entity.getPersona_resp() != null) {
            String xap="", xam="";
            if (entity.getPersona_resp().getFirstName() != null) { xap=entity.getPersona_resp().getFirstName(); }
            if (entity.getPersona_resp().getSecondName() == null) { xam=entity.getPersona_resp().getSecondName();}
            dto.setPersona_resp(entity.getPersona_resp().getName()+" "+xap+" "+xam);
        }
        // Map nested Set<DcontratosE> to List<DcontratosDTO>
        if (entity.getDcontratos() != null) {
            dto.setDcontratos(entity.getDcontratos()
                    .stream()
                    .map(McontratosMapper::mapDcontratos)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
    private static DcontratosEDto mapDcontratos(DcontratosE dcontrato) {
        if (dcontrato == null) {
            return null;
        }
        DcontratosEDto dto = new DcontratosEDto();
        dto.setImporte(dcontrato.getImporte());     //  setCodcont(dcontrato.getCodcont()); // Assuming DcontratosE has a 'codcont' field
        dto.setPrincipal(dcontrato.getPrincipal()); // dto.setCodserv(dcontrato.getCodserv()); // Assuming DcontratosE has a 'codserv' field
        dto.setLectura(dcontrato.getLectura());
        dto.setPredio(dcontrato.getPredios().getNombre());
        dto.setRubro(dcontrato.getRubros().getNombre());
        return dto;
    }

}//end of class
