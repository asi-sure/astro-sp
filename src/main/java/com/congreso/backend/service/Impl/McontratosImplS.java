package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.Dto.McontratosEDto;
import com.congreso.backend.entities.InquilinosE;
import com.congreso.backend.entities.McontratosE;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.libs.FormatoNumeros;
import com.congreso.backend.libs.GeneradorCodigos;
import com.congreso.backend.libs.ObtenerFechas;
import com.congreso.backend.mapper.McontratosMapper;
import com.congreso.backend.model.BoletasContratos;
import com.congreso.backend.model.dto.McontratosDto;
import com.congreso.backend.repository.BoletasContratosR;
import com.congreso.backend.repository.GeneralR;
import com.congreso.backend.repository.McontratosR;
import com.congreso.backend.repositoryE.McontratosRepo;
import com.congreso.backend.service.McontratosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.congreso.backend.model.General;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class McontratosImplS implements McontratosS {
    private final CustomResponseBuilder customResponseBuilder;
    private final McontratosRepo mcontratosRepo;
    private final McontratosR mcontratosR;
    private final GeneralR generalR;
    private final BoletasContratosR boletasContratosR;

    @Override
    public PaginatedResponse<McontratosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable) {
        Page<McontratosE> page = mcontratosRepo.listarMcontratos(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public PaginatedResponse<McontratosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, Pageable pageable) {
        Page<McontratosE> page2 = mcontratosRepo.listarMcontratos(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,pageable);
        Page<McontratosEDto> page =  page2.map(McontratosMapper::toDto);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    @Transactional
    public ResponseEntity<ApiResponse> save(McontratosForms in) {
        General general = generalR.findById(1); // recover data from General
        String codigo= GeneradorCodigos.generarCodigo("C",general.getContratos(),general.getAnio());
        //loading data to McontratosDto
        McontratosDto obj = new McontratosDto();
        obj.setCodcon(codigo);
        obj.setGestion(general.getGestion());
        obj.setFechaini(in.getFechaini());
        obj.setFechafin(in.getFechafin());
        obj.setEstado(1);
        obj.setCicli(in.getCodcliente());
        obj.setCiresp(in.getCodresponsable());
        obj.setTipoper("I");
        obj.setMonto(in.getMonto());
        obj.setObs(in.getObs());
        obj.setCf(1);//applyin billing
        obj.setFecha(in.getFecha());
        obj.setIndefinido(in.getIndefinido());
        obj.setStop(0);
        //loading data of Boletas
        BoletasContratos bol = new BoletasContratos();
        bol.setMes(ObtenerFechas.getMonth(in.getFechaini()));
        bol.setAnio(ObtenerFechas.getYear(in.getFechaini()));
        bol.setGestion(general.getGestion());
        bol.setCreado_por(in.getCodresponsable());

//INSERT INTO boletas_contratos(codcon,codc,codpre,   mes,anio,gestion,monto,creado_por)

        String res1 = mcontratosR.save_Mcontratos(obj);
        mcontratosR.save_Dcontratos(in.getDcontratos(),codigo);//add mcontratos
        boletasContratosR.save_boletasContratos(in.getDcontratos(),codigo,bol,obj.getFechaini()); //generar boletas
        boolean res3=generalR.update_contratos();//contador de contratos
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }
}
