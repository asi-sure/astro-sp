package com.congreso.backend.mapper;

import com.congreso.backend.entities.DacopladosE;
import com.congreso.backend.entities.DcontratosE;
import com.congreso.backend.entities.Dto.DacopladosEDto;
import com.congreso.backend.entities.Dto.DcontratosEDto;
import com.congreso.backend.entities.Dto.MacopladosEDto;
import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.McontratosE;

import java.util.stream.Collectors;

public class MacopladosMapper {
    public static MacopladosEDto toDto(MacopladosE entity) {
        if (entity == null) {
            return null;
        }

        MacopladosEDto dto = new MacopladosEDto();
        dto.setCoda(entity.getCoda());
        dto.setGestion(entity.getGestion());
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
        if (entity.getDacoplados() != null) {
            dto.setDacoplados(entity.getDacoplados()
                    .stream()
                    .map(MacopladosMapper::mapDacoplados)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
    private static DacopladosEDto mapDacoplados(DacopladosE dacoplados) {
        if (dacoplados == null) {
            return null;
        }
        DacopladosEDto dto = new DacopladosEDto();
        dto.setImporte(dacoplados.getImporte());
        dto.setRubro(dacoplados.getRubros().getNombre());
        dto.setEstado(dacoplados.getEstado());
        dto.setId_daco(dacoplados.getId_daco());
        return dto;
    }

}
