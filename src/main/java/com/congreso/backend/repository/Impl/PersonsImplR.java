package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
import com.congreso.backend.model.Role;
import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.repository.PersonsR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PersonsImplR implements PersonsR {
    private final JdbcTemplate db;
    private String sqlString;

    @Override
    public List<PersonsDto> findAll(boolean xstatus) {
//        sqlString = "SELECT * FROM persons WHERE status = ?;";
        sqlString= " SELECT p.id,s.username as usuario,p.cedula,p.name,p.first_name,p.second_name,p.email,p.photo,p.date_birth,p.status,p.gender,p.telephone " +
                   " FROM persons p LEFT JOIN system_users s " +
                   " ON p.id = s.id_person " +
                   " WHERE p.status= ?";
        return db.query(sqlString, new BeanPropertyRowMapper<>(PersonsDto.class),xstatus);
    }

    @Override
    public Persons findById(int id) {
        sqlString = "SELECT * FROM persons WHERE id = ?;";
        return db.queryForObject(sqlString, new BeanPropertyRowMapper<>(Persons.class), id);
    }

    @Override
    public List<Role> roleFindById(int id) {
        sqlString = "SELECT r.* FROM role r, rolper p WHERE (r.id_role=p.id_role)and(p.id_person=?);";
        return db.query(sqlString, new BeanPropertyRowMapper<>(Role.class), id);
    }

    @Override
    public Long savePersons(Persons person) {
        String sqlString = "  INSERT INTO persons (cedula,name,first_name,second_name,email,telephone,gender,photo,date_birth,status) "
                         + "   values (?,?,?,?,?,?,?,?,?,?) RETURNING id;";
        return db.queryForObject(sqlString, new Object[]{person.getCedula(),person.getName(),person.getFirstName(),person.getSecondName(),person.getEmail(),person.getTelephone(),person.getGender(),person.getPhoto(),person.getDateBirth(),true}, Long.class);
    }

    @Override
    public boolean update(Persons obj, int id) {
        Boolean res=false;
        if (obj.getPhoto().equals("-")) {  //sin foto  atributo photo es "-"
            String sql1 = " UPDATE persons " +
                    " SET cedula=?,name = ?,first_name=?, second_name=?,email=?,telephone=?,gender=?,date_birth=? " +
                    " WHERE id = ?;";
            res = db.update(sql1, obj.getCedula(), obj.getName(), obj.getFirstName(), obj.getSecondName(), obj.getEmail(), obj.getTelephone(), obj.getGender(), obj.getDateBirth(), id) > 0;
        }else {     //con foto
            String sql2 = " UPDATE persons " +
                    " SET cedula=?,name = ?,first_name=?, second_name=?,email=?,telephone=?,gender=?,photo=?,date_birth=? " +
                    " WHERE id = ?;";
            res = db.update(sql2, obj.getCedula(), obj.getName(), obj.getFirstName(), obj.getSecondName(), obj.getEmail(), obj.getTelephone(), obj.getGender(), obj.getPhoto(), obj.getDateBirth(), id) > 0;
        }
        return res;
    }
    @Override
    public boolean delete(int id) {
        boolean status = verificaEstado(id);
        String sql="";
        Boolean res;
        if (status){ //solo busca cedula
            sql="UPDATE persons SET status=false WHERE id = ?";
            res = db.update(sql, id) > 0;
        }else{ //busca cedula e ID
            sql="UPDATE persons SET status=true WHERE id = ?";
            res = db.update(sql, id) > 0;
        }
        return !status;
    }
    @Override
    public boolean verificarCedula(String xcedula, int id) {
        String sql="";
        Boolean existe;
        if (id==0){ //solo busca cedula
            sql="SELECT EXISTS(SELECT 1 FROM persons WHERE cedula = ?)";
            existe = db.queryForObject(sql, Boolean.class, xcedula);
        }else{ //busca cedula e ID
            sql="SELECT EXISTS(SELECT 1 FROM persons WHERE cedula = ? and id<> ?)";
            existe = db.queryForObject(sql, Boolean.class, xcedula, id);
        }
        return existe != null && existe;
    }
    public boolean verificaEstado(int id) {
        String sql="SELECT status FROM persons WHERE id = ?";
        return db.queryForObject(sql, Boolean.class, id);
    }
        /*
        public List<City> findCitiesByStatusBetween(int minStatus, int maxStatus) {
            // Define the SQL query directly within the method or as a constant
            sql = "SELECT * FROM city WHERE status BETWEEN ? AND ?";

            // Pass the parameters as arguments to the query method
            // The order of parameters matters: minStatus replaces the first ?, maxStatus replaces the second ?
            return db.query(sql, new BeanPropertyRowMapper<>(City.class), minStatus, maxStatus);
        }
        @Override
        public List<Departament> findAll() {
            sql = "SELECT * FROM departament WHERE status = true;";
            return db.query(sql, new BeanPropertyRowMapper<Departament>(Departament.class));
        }
     */
    //return db.query(sqlString, new BeanPropertyRowMapper<>(Persons.class),xstatus);
}
