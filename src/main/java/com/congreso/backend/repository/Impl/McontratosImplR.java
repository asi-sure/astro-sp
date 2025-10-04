package com.congreso.backend.repository.Impl;

import com.congreso.backend.entities.forms.DcontratosForms;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.model.dto.McontratosDto;
import com.congreso.backend.repository.McontratosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class McontratosImplR implements McontratosR {
    private final JdbcTemplate db;
    private String sql;
    @Override
    public String save_Mcontratos(McontratosDto obj) {
        sql = " INSERT INTO mcontratos(codcon,gestion,fechaini,fechafin,cicli,ciresp,tipoper,monto,obs,cf,fecha,indefinido) "+
                "  values(?,?,?,?,?,?,?,?,?,?,?,?) RETURNING codcon ";
        return db.queryForObject(sql, new Object[]{obj.getCodcon(),obj.getGestion(),obj.getFechaini(),obj.getFechafin(),obj.getCicli(),obj.getCiresp(),obj.getTipoper(),obj.getMonto(),obj.getObs(),obj.getCf(),obj.getFecha(),obj.getIndefinido()}, String.class);
    }
    @Override
    public void save_Dcontratos(List<DcontratosForms> obj, String codcon) {
        sql = " INSERT INTO dcontratos(codcon,codc,codpre,importe,principal) "+
              "  values(?,?,?,?,?) ";
        obj.forEach(det ->{
            db.update(sql,codcon,det.getCodc(),det.getCodpre(),det.getImporte(),det.getPrincipal());
        });
    }

} //end of class
