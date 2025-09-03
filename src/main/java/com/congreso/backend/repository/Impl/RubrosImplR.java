package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Persons;
import com.congreso.backend.model.forms.InquilinosForm;
import com.congreso.backend.model.forms.RubrosForm;
import com.congreso.backend.repository.RubrosR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RubrosImplR implements RubrosR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public RubrosForm findByCodc(String codc) {
        sql = " SELECT codc, nombre,estado, padre "+
              " FROM rubros WHERE codc = ? ;";
        return db.queryForObject(sql, new BeanPropertyRowMapper<>(RubrosForm.class), codc);
    }
    @Override
    public List<RubrosForm> findAllPadre() {
        sql = " SELECT codc, nombre,estado, padre "+
                " FROM rubros WHERE estado = 1 and deta ='G' ;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(RubrosForm.class));
    }

    @Override
    public String save(RubrosForm obj) {
        String cadd=obj.getPadre().trim();
        String res="";
        if (cadd.equals("0")||cadd.equals("")){
            sql = " INSERT INTO rubros(codc,nombre,estado,tipo,deta) "+
                  "      values(?,?,?,?,?) RETURNING codc ";
            res=db.queryForObject(sql, new Object[]{obj.getCodc(),obj.getNombre(),1,1,'G'}, String.class);
        }else {
            sql = " INSERT INTO rubros(codc,nombre,estado,tipo,padre,deta) " +
                    "      values(?,?,?,?,?,?) RETURNING codc ";
            res=db.queryForObject(sql, new Object[]{obj.getCodc(),obj.getNombre(),1,1,obj.getPadre(),'D'}, String.class);
        }
        return res;
    }

}
