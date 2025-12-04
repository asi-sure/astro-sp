package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.General;
import com.congreso.backend.model.Persons;
import com.congreso.backend.repository.GeneralR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class GeneralmplR implements GeneralR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public General findById(int id) {
        sql = "SELECT * FROM general WHERE id = 1;";
        return db.queryForObject(sql, new BeanPropertyRowMapper<>(General.class));
    }

    @Override
    public boolean update_contratos() {
        Boolean res=false;
        String sql = " UPDATE general SET contratos=contratos + 1 WHERE id = 1;";
        res = db.update(sql) > 0;
        return res;
    }

    @Override
    public boolean update_acoplados() {
        Boolean res=false;
        String sql = " UPDATE general SET acoplados=acoplados + 1 WHERE id = 1;";
        res = db.update(sql) > 0;
        return res;
    }
}
