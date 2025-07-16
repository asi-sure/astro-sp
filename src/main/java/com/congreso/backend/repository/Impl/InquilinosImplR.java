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

    @Override
    public Long save(InquilinosForm obj) {
        sql = " INSERT INTO inquilinos(cedula,nombre,ap,am,direc,celular,ubicacion,estado) "+
              "      values(?,?,?,?,?,?,?,?) RETURNING id ";
        return db.queryForObject(sql, new Object[]{obj.getCedula(),obj.getNombre(),obj.getAp(),obj.getAm(),obj.getDirec(),obj.getCelular(),obj.getUbicacion(),true}, Long.class);
    }

    @Override
    public boolean update(InquilinosForm obj, int id) {
        Boolean res=false;
        if (obj.getUbicacion().equals("-")) {  //sin foto  atributo photo es "-"
            String sql1 = " UPDATE inquilinos "+
                          " SET cedula=?,nombre = ?,ap=?, am=?,direc=?,celular=?  "+
                          " WHERE id = ?; ";
            res = db.update(sql1, obj.getCedula(), obj.getNombre(),obj.getAp(),obj.getAm(),obj.getDirec(),obj.getCelular(), id) > 0;
        }else {     //con foto
            String sql2 = " UPDATE inquilinos " +
                          " SET cedula=?,nombre = ?,ap=?, am=?,direc=?,celular=?,ubicacion=?  " +
                          " WHERE id = ?;";
            res = db.update(sql2, obj.getCedula(), obj.getNombre(),obj.getAp(),obj.getAm(),obj.getDirec(),obj.getCelular(),obj.getUbicacion(), id) > 0;
        }
        return res;
    }

    @Override
    public boolean verificarCedula(String xcedula, int id) {
        String sql="";
        Boolean existe;

        if (id==0){ //solo busca cedula
            sql="SELECT EXISTS(SELECT 1 FROM inquilinos WHERE cedula = ?)";
            existe = db.queryForObject(sql, Boolean.class, xcedula);
            System.out.println("xcedula::"+xcedula+" id:"+id+" existe:"+existe);
        }else{ //busca cedula e ID
            sql="SELECT EXISTS(SELECT 1 FROM inquilinos WHERE cedula = ? and id<> ?)";
            existe = db.queryForObject(sql, Boolean.class, xcedula, id);
        }
        return existe != null && existe;
    }
}
