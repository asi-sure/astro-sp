package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.City;
import com.congreso.backend.repository.CityR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CityImplR implements CityR {
    public final JdbcTemplate db;
    private String sql;

    @Override
    public List<City> findAll() {
        sql = "SELECT * FROM city WHERE status = true;";
        return db.query(sql, new BeanPropertyRowMapper<City>(City.class));
    }

    @Override
    public City findById(Long id) {
        sql = "SELECT * FROM city WHERE id = ?";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(City.class), id);
    }

    @Override
    public boolean save(City obj) {
        sql = "INSERT INTO city (name,description) VALUES (?,?)";
        return db.update(sql, obj.getName(), obj.getDescription()) > 0;
    }

    @Override
    public boolean update(City obj, Long id) {
        sql = "UPDATE city SET name = ?, description = ? WHERE id = ?";
        return db.update(sql, obj.getName(), obj.getDescription(), id) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        sql = "UPDATE city SET status = false WHERE id = ?";
        return db.update(sql, id) > 0;
    }
}
