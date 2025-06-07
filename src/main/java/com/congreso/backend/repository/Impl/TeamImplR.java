package com.congreso.backend.repository.Impl;

import com.congreso.backend.model.Team;
import com.congreso.backend.repository.TeamR;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamImplR implements TeamR {
    private final JdbcTemplate db;
    private String sql;

    @Override
    public List<Team> findAll() {
        sql = "SELECT * FROM team WHERE status = true ;";
        return db.query(sql, new BeanPropertyRowMapper<>(Team.class));
    }

    @Override
    public Team findById(Integer id) {
        sql = "SELECT * FROM team WHERE id = ?;";
        return (Team) db.query(sql, new BeanPropertyRowMapper<>(Team.class), id);
    }

    @Override
    public boolean save(Team team) {
        sql = "INSERT INTO team (alias, description) VALUES (?, ?);";
        return db.update(sql, team.getAlias(), team.getDescription()) > 0;
    }

    @Override
    public boolean update(Team obj, Integer id) {
        sql = "UPDATE team SET alias = ?, description = ? WHERE id = ?;";
        return db.update(sql, obj.getAlias(), obj.getDescription(), id) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        sql = "UPDATE team SET status = false WHERE id = ?;";
        return db.update(sql, id) > 0;
    }
}
