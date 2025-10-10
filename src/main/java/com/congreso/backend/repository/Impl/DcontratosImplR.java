package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Dcontratos;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.repository.DcontratosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DcontratosImplR implements DcontratosR {
    private final JdbcTemplate db;
    private String sql;
    @Override
    public List<Dcontratos> findByCodcon(String codcon) {
        sql = " SELECT id_dcon, importe,principal,lectura "+
                " FROM dcontratos WHERE codcon = ? ;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Dcontratos.class),codcon);
    }
}
