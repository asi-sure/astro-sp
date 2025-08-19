package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Secciones;
import com.congreso.backend.model.Sectores;
import com.congreso.backend.repository.SeccionesR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SeccionesImplR implements SeccionesR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public Long save(Secciones obj) {
        sql = " INSERT INTO secciones(cods,nombre,estado) "+
                "  values(?,?,?) RETURNING cods ";
        return db.queryForObject(sql, new Object[]{obj.getCods(),obj.getNombre(),1}, Long.class);
    }
    @Override
    public boolean update(Secciones obj, int id) {
        Boolean res=false;
        String sql1 = " UPDATE secciones "+
                " SET nombre = ?, cods= ? "+
                " WHERE codsec = ?; ";
        res = db.update(sql1, obj.getNombre(), obj.getCods(),id) > 0;
        return res;
    }

    @Override
    public boolean delete(int estado, int id) {
        Boolean res;
        String sql="UPDATE secciones SET estado=1 - ? WHERE codsec = ?";
        res = db.update(sql,estado, id) > 0;
        return !res;
    }

    @Override
    public boolean verificarNombre(String nombre, int id) {
        Boolean existe;
        if (id == 0) {
            String sql = "SELECT EXISTS(SELECT 1 FROM secciones WHERE upper(nombre) = upper(?))";
            existe = db.queryForObject(sql, Boolean.class, nombre);
        }else{
            String sql = "SELECT EXISTS(SELECT 1 FROM secciones WHERE upper(nombre) = upper(?) and (codsec <> ?))";
            existe = db.queryForObject(sql, Boolean.class, nombre, id);
        }
        return existe != null && existe;
    }
}
