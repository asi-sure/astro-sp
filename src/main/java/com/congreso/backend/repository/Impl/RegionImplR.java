package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Region;
import com.congreso.backend.repository.RegionR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegionImplR implements RegionR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public List<Region> findAll() {
        sql = "SELECT * FROM region WHERE status = true;";
        return db.query(sql, new BeanPropertyRowMapper<>(Region.class));
    }

    @Override
    public Region findById(Integer id) {
        sql = "SELECT * FROM region WHERE id = ?;";
        return (Region) db.query(sql, new BeanPropertyRowMapper<>(Region.class), id);
    }

    @Override
    public boolean save(Region obj) {
        sql = "INSERT INTO region (name, description) VALUES (?, ?);";
        return db.update(sql, obj.getName(), obj.getDescription()) > 0;
    }

    @Override
    public boolean update(Region obj, Integer id) {
        sql = "UPDATE region SET name = ?, description = ? WHERE id = ?;";
        return db.update(sql, obj.getName(), obj.getDescription(), id) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        sql = "UPDATE region SET status = false WHERE id = ?;";
        return db.update(sql, id) > 0;
    }
}
