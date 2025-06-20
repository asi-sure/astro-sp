package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Person;
import com.congreso.backend.model.Persons;
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
    public List<Persons> findAll(boolean xstatus) {
        sqlString = "SELECT * FROM persons WHERE status = ?;";
        return db.query(sqlString, new BeanPropertyRowMapper<>(Persons.class),xstatus);
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
    @Override
    public Long savePersons(Persons person) {
        String sqlString = "  INSERT INTO persons (cedula,name,first_name,second_name,email,telephone,gender,photo,date_birth,status) "
                         + "   values (?,?,?,?,?,?,?,?,?,?) RETURNING id;";
        return db.queryForObject(sqlString, new Object[]{person.getCedula(),person.getName(),person.getFirstName(),person.getSecondName(),person.getEmail(),person.getTelephone(),person.getGender(),person.getPhoto(),person.getDateBirth(),true}, Long.class);
    }

    @Override
    public boolean update(Persons obj, int id) {
        String sql =" UPDATE persons "+
                    " SET cedula=?,name = ?,first_name=?, second_name=?,email=?,telefono=?,gender=?,photo=?,date_birth=? "+
                    " WHERE id = ?;";
        return db.update(sql,obj.getCedula(),obj.getName(),obj.getFirstName(),obj.getSecondName(),obj.getEmail(),obj.getTelephone(),obj.getGender(),obj.getPhoto(),obj.getDateBirth(), id) > 0;
    }

    @Override
    public boolean verificarCedula(String xcedula, int id) {
        return false;
    }


}
