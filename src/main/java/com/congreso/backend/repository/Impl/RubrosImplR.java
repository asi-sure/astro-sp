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
    public List<RubrosForm> findSoloPadre() {
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

    @Override  //DEBO CONTROLAR A QUIEN SE MODIFICA, SI PADRE O HIJO
    public boolean update(RubrosForm obj, String codc) {
        String padre = obj.getPadre().trim();
        String sql;
        Boolean res=false;
        if (padre.equals("0") || padre == null){ //si es padre
            sql = " UPDATE rubros "+
                  " SET nombre=? "+
                  " WHERE codc = ? and deta='G'; ";
            res = db.update(sql, obj.getNombre(), codc) > 0;
        }else {  //si es hijo.
            sql = " UPDATE rubros " +
                  " SET nombre=?, padre=?  " +
                  " WHERE codc = ? and deta='D'; ";
            res = db.update(sql, obj.getNombre(), obj.getPadre(), codc) > 0;
        }
        return res;
    }

    @Override
    public int delete(String codc) {
        int status = verificaEstado(codc);
        boolean tieneHijos = verificaPadreSinHijos(codc);
        if (tieneHijos) { return 2; } //si tiene hijos activos retorna 2
        String sql="";
        Boolean res;
        if (status==1){
            sql="UPDATE rubros SET estado=0 WHERE codc = ?";
            res = db.update(sql, codc) > 0;
            status=0;
        }else{
            sql="UPDATE rubros SET status=1 WHERE codc = ?";
            res = db.update(sql, codc) > 0;
            status=1;
        }
        return status;
    }

    ////////// EXTRAS
    @Override
    public boolean verificarKey(String codc) {
        Boolean existe;
        String sql="SELECT EXISTS(SELECT 1 FROM rubros WHERE codc = ?)";
        existe = db.queryForObject(sql, Boolean.class, codc);
        return existe != null && existe;
    }
    @Override
    public boolean verificarNombre(String codc, String nombre) {
        String sql="";
        Boolean existe;
        if (codc.equals("0")){ //si es adicinar ADD
            sql="SELECT EXISTS(SELECT 1 FROM rubros WHERE nombre=?)";
            existe = db.queryForObject(sql, Boolean.class, nombre);
        }else{ //si es modificar MOD
            sql="SELECT EXISTS(SELECT 1 FROM rubros WHERE nombre = ? and codc<> ?)";
            existe = db.queryForObject(sql, Boolean.class, nombre, codc);
        }
        return existe != null && existe;
    }
    public int verificaEstado(String codc) {
        String sql="SELECT estado FROM rubros WHERE codc = ?";
        return db.queryForObject(sql, Integer.class, codc);
    }
    public Boolean verificaPadreSinHijos(String codc) {
        String sql="SELECT count(*)>0 FROM rubros WHERE padre = ? and estado=1 and deta='D'";
        return db.queryForObject(sql, Boolean.class, codc);
    }

//    @Override  //verificar si existe CODC
//    public boolean verificarExistenciaCodc(String xcodc) {
//        String sql="";
//        Boolean existe;
//        if (id==0){ //solo busca cedula
//            sql="SELECT EXISTS(SELECT 1 FROM inquilinos WHERE cedula = ?)";
//            existe = db.queryForObject(sql, Boolean.class, xcedula);
//            System.out.println("xcedula::"+xcedula+" id:"+id+" existe:"+existe);
//        }else{ //busca cedula e ID
//            sql="SELECT EXISTS(SELECT 1 FROM inquilinos WHERE cedula = ? and id<> ?)";
//            existe = db.queryForObject(sql, Boolean.class, xcedula, id);
//        }
//        return existe != null && existe;
//    }
}//end of class
