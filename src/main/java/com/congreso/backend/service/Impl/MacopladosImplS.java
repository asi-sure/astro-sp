package com.congreso.backend.service.Impl;

import com.congreso.backend.entities.BoletasAcopladosE;
import com.congreso.backend.entities.Dto.MacopladosEDto;
import com.congreso.backend.entities.MacopladosE;
import com.congreso.backend.entities.forms.MacopladosForms;
import com.congreso.backend.entities.forms.MacopladosForms2;
import com.congreso.backend.entities.forms.McontratosForms2;
import com.congreso.backend.libs.GeneradorCodigos;
import com.congreso.backend.libs.ObtenerFechas;
import com.congreso.backend.mapper.MacopladosMapper;
import com.congreso.backend.model.Dacoplados;
import com.congreso.backend.model.General;
import com.congreso.backend.model.dto.MacopladosDto;
import com.congreso.backend.repository.*;
import com.congreso.backend.repositoryE.MacopladosRepo;
import com.congreso.backend.service.MacopladosS;
import com.congreso.backend.utils.ApiResponse;
import com.congreso.backend.utils.CustomResponseBuilder;
import com.congreso.backend.utils.PaginatedResponse;
import com.congreso.backend.utils.PaginationUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@RequiredArgsConstructor
@Service
public class MacopladosImplS implements MacopladosS {
    private final CustomResponseBuilder customResponseBuilder;

    private final MacopladosRepo macopladosRepo;
    private final MacopladosR macopladosR;
    private final DacopladosR dacopladosR;
    private final GeneralR generalR;
    private final BoletasAcopladosR boletasAcopladosR;

    @Override
    public PaginatedResponse<MacopladosE> findAll(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable) {
        Page<MacopladosE> page = macopladosRepo.listarMacoplados(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,stop,pageable);
        return PaginationUtils.toPaginatedResponse(page);
    }
    @Override
    public PaginatedResponse<MacopladosEDto> findAll_2(int xestado, String buscar, LocalDate fechaini, LocalDate fechafin, int stop, Pageable pageable) {
        Page<MacopladosE> page2 = macopladosRepo.listarMacoplados(xestado,"%"+buscar.trim()+"%",fechaini,fechafin,stop,pageable);
        Page<MacopladosEDto> page =  page2.map(MacopladosMapper::toDto);
        return PaginationUtils.toPaginatedResponse(page);
    }

    @Override
    public ResponseEntity<ApiResponse> findByCoda(String xcodca) {
        MacopladosE acoplados = macopladosRepo.obtenerMacoplados(xcodca);
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", acoplados,null);
    }
//    @Override
//    public ResponseEntity<ApiResponse> findByCoda222(String xcoda) {
//        MacopladosForms2 acoplados = macopladosR.findByCoda(xcoda);
//        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Búsqueda exitosa.", acoplados,null);
//    }

    @Override
    public ResponseEntity<ApiResponse> save(MacopladosForms in) {
        //validation begin
        //validation end
        General general = generalR.findById(1); // recover data from General
        String codigo= GeneradorCodigos.generarCodigo("A",general.getAcoplados(),general.getAnio());
        //loading data to McontratosDto
        MacopladosDto obj = new MacopladosDto();
        obj.setCoda(codigo);
        obj.setGestion(general.getGestion());
        obj.setEstado(1);
        obj.setCicli(in.getCodcliente());
        obj.setCiresp(in.getCodresponsable());
        obj.setObs(in.getObs());
        obj.setCf(1);//applyin billing
        obj.setFecha(in.getFecha());
        obj.setStop(0);
        final float[] xmonto = {0};
        AtomicBoolean xban= new AtomicBoolean(true);
        in.getDacoplados().forEach(det ->{
            xmonto[0] = xmonto[0] + det.getImporte();
            if (det.getImporte()<=0) { xban.set(false); }
        });
        if (!xban.get()) {
            throw new IllegalArgumentException("El MONTO en Detalle Acoplado debe ser mayor a cero.");
        }
        obj.setMonto(xmonto[0]); //actualiza monto

//        //loading data of Boletas
        BoletasAcopladosE bol = new BoletasAcopladosE();
        bol.setMes(ObtenerFechas.getMonth(in.getFecha()));
        bol.setAnio(ObtenerFechas.getYear(in.getFecha()));
        bol.setGestion(general.getGestion());
        bol.setCreado_por(in.getCodresponsable());
//
        //save mcontratos
        String res1 = macopladosR.save_Macoplados(obj);
        macopladosR.save_Dacoplados(in.getDacoplados(),codigo);//save macoplados
//        boletasContratosR.save_boletasContratos(obj,bol); //generar boletas
        List<Dacoplados> dacoplados = dacopladosR.findByCoda(codigo);
        dacoplados.forEach(det ->{
            boletasAcopladosR.save_boletasAcoplados(det.getId_daco(),in.getFecha(),det.getImporte(),bol); //generar boletas
        });

        boolean res3=generalR.update_acoplados();//contador de acoplados
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Consulta exitosa.", null);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(String coda, int idresponsable) {
        boolean status = macopladosRepo.callDeleteAcopladosNative(coda, idresponsable);
        String mensaje="";
        if (status) {
            mensaje="Se Eliminó satisfactoriamente.";
        }else{
            mensaje="No se puede Eliminar el contrato por tener DATOS pendientes. Revisar!";
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), mensaje, 0);
    }

    @Override
    @Transactional
    public ResponseEntity<ApiResponse> update(MacopladosForms in, String coda) {
        boolean status = macopladosRepo.callModificarAcoplados(coda, Math.toIntExact(in.getCodresponsable()));
        if (status==false) {
            throw new DataIntegrityViolationException("No se puede realizar la Modificación por REFERENCIA a datos..");
        }
//DataIntegrityViolationException
        General general = generalR.findById(1); // recover data from General
        String codigo= GeneradorCodigos.generarCodigo("A",general.getAcoplados(),general.getAnio());
        //loading data to McontratosDto
        MacopladosDto obj = new MacopladosDto();
        obj.setCoda(codigo);
        obj.setGestion(general.getGestion());
        obj.setEstado(1);
        obj.setCicli(in.getCodcliente());
        obj.setCiresp(in.getCodresponsable());
        obj.setObs(in.getObs());
        obj.setCf(1);//applyin billing
        obj.setFecha(in.getFecha());
        obj.setStop(0);
        final float[] xmonto = {0};
        AtomicBoolean xban= new AtomicBoolean(true);
        in.getDacoplados().forEach(det ->{
            xmonto[0] = xmonto[0] + det.getImporte();
            if (det.getImporte()<=0) { xban.set(false); }
        });
        if (!xban.get()) {
            throw new IllegalArgumentException("El MONTO en Detalle Acoplado debe ser mayor a cero.");
        }
        obj.setMonto(xmonto[0]); //actualiza monto
//        //loading data of Boletas
        BoletasAcopladosE bol = new BoletasAcopladosE();
        bol.setMes(ObtenerFechas.getMonth(in.getFecha()));
        bol.setAnio(ObtenerFechas.getYear(in.getFecha()));
        bol.setGestion(general.getGestion());
        bol.setCreado_por(in.getCodresponsable());
//
        //save mcontratos
        String res1 = macopladosR.save_Macoplados(obj);
        macopladosR.save_Dacoplados(in.getDacoplados(),codigo);//save macoplados
//        boletasContratosR.save_boletasContratos(obj,bol); //generar boletas
        List<Dacoplados> dacoplados = dacopladosR.findByCoda(codigo);
        dacoplados.forEach(det ->{
            boletasAcopladosR.save_boletasAcoplados(det.getId_daco(),in.getFecha(),det.getImporte(),bol); //generar boletas
        });

        boolean res3=generalR.update_acoplados();//contador de acoplados

        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "Se modificó satisfactoriamente..!", 0);
    }
    @Override
    public ResponseEntity<ApiResponse> parar_acoplados(MacopladosForms2 in, String coda) {
        boolean status = macopladosRepo.callStopAcoplados(coda,in.getCodresponsable(),in.getObs());
        if (status == false) {
            throw new IllegalArgumentException("No se puedo ejecutar la transacción.");
        }
        return customResponseBuilder.buildResponse(HttpStatus.OK.value(), "El contrato se Canceló satisfactoriamente..!", 0);
    }

}
