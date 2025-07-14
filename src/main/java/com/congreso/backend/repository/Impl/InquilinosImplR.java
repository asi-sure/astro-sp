package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.repository.InquilinosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class InquilinosImplR implements InquilinosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public List<InquilinosForm> findAll(boolean xestado) {
        sql = " SELECT id,cedula,nombre,ap,am,direc,celular,ubicacion,estado "+
              " FROM inquilinos WHERE estado = ? ;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(InquilinosForm.class),xestado);
    }
}
