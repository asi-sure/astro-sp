package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Sectores;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.repository.SectoresR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SectoresImplR implements SectoresR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public Long save(Sectores obj) {
        sql = " INSERT INTO sectores(nombre,estado) "+
                "  values(?,?) RETURNING cods ";
        return db.queryForObject(sql, new Object[]{obj.getNombre(),1}, Long.class);
    }

    @Override
    public boolean verificarNombre(String nombre) {
        Boolean existe;
        String sql="SELECT EXISTS(SELECT 1 FROM sectores WHERE upper(nombre) = upper(?))";
        existe = db.queryForObject(sql, Boolean.class, nombre);
        return existe != null && existe;
    }

//    @Override
//    public List<Sectores> findAll(int xestado) {
//        sql = " SELECT cods, nombre, estado "+
//              " FROM sectores WHERE estado = ? ;";
//        return db.query(sql, BeanPropertyRowMapper.newInstance(Sectores.class),xestado);
//    }
}
