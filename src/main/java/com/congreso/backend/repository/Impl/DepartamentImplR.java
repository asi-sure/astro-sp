package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Departament;
import com.congreso.backend.repository.DepartamentR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartamentImplR implements DepartamentR {
    public final JdbcTemplate db;
    private String sql;

    @Override
    public List<Departament> findAll() {
        sql = "SELECT * FROM departament WHERE status = true;";
        return db.query(sql, new BeanPropertyRowMapper<Departament>(Departament.class));
    }

    @Override
    public Departament findById(Integer id) {
        sql = "SELECT * FROM departament WHERE id = ?;";
        return (Departament) db.query(sql, new BeanPropertyRowMapper<>(Departament.class), id);
    }

    @Override
    public boolean save(Departament obj) {
        sql = "INSERT INTO departament(name, description) VALUES(?,?);";
        return db.update(sql, obj.getName(), obj.getDescription()) > 0;
    }

    @Override
    public boolean update(Departament obj, Integer id) {
        sql = "UPDATE department SET name = ?, description = ? WHERE id = ?;";
        return db.update(sql, obj.getName(), obj.getDescription(), id) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        sql = "UPDATE departament SET status = false  WHERE id = ?;";
        return db.update(sql, id) > 0;
    }
}
