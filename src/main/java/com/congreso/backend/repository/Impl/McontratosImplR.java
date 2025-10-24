package com.congreso.backend.repository.Impl;

import com.congreso.backend.entities.forms.DcontratosForms;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.model.dto.McontratosDto;
import com.congreso.backend.repository.McontratosR;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class McontratosImplR implements McontratosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public String save_Mcontratos(McontratosDto obj) {
        sql = " INSERT INTO mcontratos(codcon,codpre,codc,tipocon,gestion,fechaini,fechafin,cicli,ciresp,monto,obs,cf,fecha,indefinido) "+
                "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING codcon ";
        return db.queryForObject(sql, new Object[]{obj.getCodcon(),obj.getPredio(),obj.getRubro(),obj.getTipocon(),obj.getGestion(),obj.getFechaini(),obj.getFechafin(),obj.getCicli(),obj.getCiresp(),obj.getMonto(),obj.getObs(),obj.getCf(),obj.getFecha(),obj.getIndefinido()}, String.class);
    }
    @Override
    public void save_Dcontratos(List<DcontratosForms> obj, String codcon) {
        sql = " INSERT INTO dcontratos(codcon,codc,importe,estado) "+
              "  values(?,?,?,?) ";
        obj.forEach(det ->{
            db.update(sql,codcon,det.getCodc(),0,1);
        });
    }

} //end of class
