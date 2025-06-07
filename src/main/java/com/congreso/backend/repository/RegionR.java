package com.congreso.backend.repository;

import com.congreso.backend.model.Region;

import java.util.List;

public interface RegionR {
    List<Region> findAll();

    Region findById(Integer id);

    boolean save(Region obj);

    boolean update(Region obj, Integer id);

    boolean deleteById(Integer id);
}
