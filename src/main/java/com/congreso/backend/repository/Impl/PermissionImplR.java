package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Permission;
import com.congreso.backend.repository.PermissionR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PermissionImplR implements PermissionR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public List<Permission> findAll() {
        sql = "SELECT * FROM permission WHERE status = true;";
        return db.query(sql, BeanPropertyRowMapper.newInstance(Permission.class));
    }

    @Override
    public Permission findById(Integer id) {
        sql = "SELECT * FROM permission WHERE id = ?";
        return db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Permission.class), id);
    }

    @Override
    public boolean save(Permission permission) {
        sql = "INSERT INTO permission (name, description) VALUES (?, ?)";
        boolean result = db.update(sql, permission.getName(), permission.getDescription()) > 0;
        return result;
    }

    @Override
    public boolean update(Permission permission, Integer id) {
        sql = "UPDATE permission SET name = ?, description = ? WHERE id = ?";
        boolean result = db.update(sql, permission.getName(), permission.getDescription(), id) > 0;
        return result;
    }

    @Override
    public boolean deleteById(Integer id) {
        sql = "UPDATE permission SET status = false WHERE id = ?";
        boolean result = db.update(sql, id) > 0;
        return result;
    }
}
