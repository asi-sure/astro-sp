package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Dacoplados;
import com.congreso.backend.model.Dcontratos;
import com.congreso.backend.repository.DacopladosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DacopladosImplR implements DacopladosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public List<Dacoplados> findByCoda(String coda) {
        sql = " SELECT id_daco,coda,codc, importe,estado "+
              " FROM dacoplados WHERE coda = ? ;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Dacoplados.class),coda);
    }




}
