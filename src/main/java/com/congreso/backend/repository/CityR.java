package com.congreso.backend.repository;

import com.congreso.backend.model.City;

import java.util.List;

public interface CityR {
    List<City> findAll();

    City findById(Long id);

    boolean save(City obj);

    boolean update(City obj, Long id);

    boolean deleteById(Long id);
}
