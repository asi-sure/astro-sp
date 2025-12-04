package com.congreso.backend.repository.Impl;

import com.congreso.backend.entities.forms.DacopladosForms;
import com.congreso.backend.entities.forms.MacopladosForms2;
import com.congreso.backend.model.dto.MacopladosDto;
import com.congreso.backend.repository.MacopladosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MacopladosImplR implements MacopladosR {
    private final JdbcTemplate db;
    private String sql;
    @Override
    public MacopladosForms2 findByCoda(String coda) {
        sql = " select coda,obs,ciresp as codresponsable "+
              " from macoplados "+
              " where coda = ? ";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(MacopladosForms2.class),coda);
    }
    @Override
    public String save_Macoplados(MacopladosDto obj) {
        sql = " INSERT INTO macoplados(coda,gestion,estado,cicli,ciresp,monto,obs,cf,fecha) "+
                "  values(?,?,?,?,?,?,?,?,?) RETURNING coda ";
        return db.queryForObject(sql, new Object[]{obj.getCoda(),obj.getGestion(),obj.getEstado(),obj.getCicli(),obj.getCiresp(),obj.getMonto(),obj.getObs(),obj.getCf(),obj.getFecha()}, String.class);
    }
    @Override
    public void save_Dacoplados(List<DacopladosForms> obj, String coda) {
        sql = " INSERT INTO dacoplados(coda,codc,importe,estado) "+
              "  values(?,?,?,?) ";
        obj.forEach(det ->{
            db.update(sql,coda,det.getCodc(),det.getImporte(),1);
        });
    }


}
