package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Predios;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.model.dto.PrediosDto;
import com.congreso.backend.repository.PrediosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PrediosImplR implements PrediosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public Predios findById(String codpre) {
        sql = "SELECT * FROM predios WHERE codpre = ?;";
        return db.queryForObject(sql, new BeanPropertyRowMapper<>(Predios.class), codpre);
    }
    @Override
    public List<PrediosDto> listarPrediosLibres() {
        sql = " SELECT p.codpre,p.nombre as nompredio,s.nombre as nomseccion,e.nombre as nomsector "+
              " FROM predios p, secciones s, sectores e "+
              " WHERE p.codsec=s.codsec and s.cods=e.cods and "+
              " e.estado=1 and s.estado=1 and p.estado=1 and p.libre='L' ";
        return db.query(sql, new BeanPropertyRowMapper<>(PrediosDto.class));
    }

    @Override
    public String save(Predios obj) {
        sql = " INSERT INTO predios(codpre,codsec,nombre,estado,libre) "+
                "  values(?,?,?,?,?) RETURNING codpre ";
        return db.queryForObject(sql, new Object[]{obj.getCodpre(),obj.getCodsec(),obj.getNombre(),1,"L"}, String.class);
    }

    @Override
    public boolean update(Predios obj, String id) {
        Boolean res=false;
        String sql1 = " UPDATE predios "+
                      " SET nombre = ?, codsec= ? "+
                      " WHERE codpre = ?; ";
        res = db.update(sql1, obj.getNombre(), obj.getCodsec(),id) > 0;
        return res;
    }

    @Override
    public boolean delete(int estado,String id) {
        Boolean res;
        String sql="UPDATE predios SET estado=1 - ? WHERE codpre = ?";
        res = db.update(sql,estado,id) > 0;
        return !res;
    }

    @Override
    public boolean verificarNombre(String nombre, String id) {
        Boolean existe;
        if (id.equals("0") || id.equals(" ") || id.isEmpty()) {
            String sql = "SELECT EXISTS(SELECT 1 FROM predios WHERE upper(nombre) = upper(?))";
            existe = db.queryForObject(sql, Boolean.class, nombre);
        }else{
            String sql = "SELECT EXISTS(SELECT 1 FROM predios WHERE upper(nombre) = upper(?) and (upper(codpre) <> upper(?)))";
            existe = db.queryForObject(sql, Boolean.class, nombre, id);
        }
        return existe != null && existe;
    }


} //End of the Class
