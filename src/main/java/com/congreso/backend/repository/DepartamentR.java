package com.congreso.backend.repository;

import com.congreso.backend.model.Departament;

import java.util.List;

public interface DepartamentR {
    List<Departament> findAll();

    Departament findById(Integer id);

    boolean save(Departament obj);

    boolean update(Departament obj, Integer id);

    boolean deleteById(Integer id);
}
