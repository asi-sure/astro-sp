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
    public boolean update(Sectores obj, int id) {
        Boolean res=false;
        String sql1 = " UPDATE sectores "+
                " SET nombre = ? "+
                " WHERE cods = ?; ";
        res = db.update(sql1, obj.getNombre(),id) > 0;
        return res;
    }
    @Override
    public boolean delete(int estado,int id) {
        Boolean res;
        String sql="UPDATE sectores SET estado=1 - ? WHERE cods = ?";
        res = db.update(sql,estado, id) > 0;
        return !res;
    }

    @Override
    public boolean verificarNombre(String nombre, int id) {
        Boolean existe;
        if (id == 0) {
            String sql = "SELECT EXISTS(SELECT 1 FROM sectores WHERE upper(nombre) = upper(?))";
            existe = db.queryForObject(sql, Boolean.class, nombre);
        }else{
            String sql = "SELECT EXISTS(SELECT 1 FROM sectores WHERE upper(nombre) = upper(?) and (cods <> ?))";
            existe = db.queryForObject(sql, Boolean.class, nombre, id);
        }
        return existe != null && existe;
    }


//    @Override
//    public List<Sectores> findAll(int xestado) {
//        sql = " SELECT cods, nombre, estado "+
//              " FROM sectores WHERE estado = ? ;";
//        return db.query(sql, BeanPropertyRowMapper.newInstance(Sectores.class),xestado);
//    }
}
