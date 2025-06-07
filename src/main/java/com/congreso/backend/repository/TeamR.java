package com.congreso.backend.repository;

import com.congreso.backend.model.Team;

import java.util.List;

public interface TeamR {
    List<Team> findAll();

    Team findById(Integer id);

    boolean save(Team team);

    boolean update(Team obj, Integer id);

    boolean deleteById(Integer id);
}
