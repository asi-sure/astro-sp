package com.congreso.backend.repository;

import com.congreso.backend.model.Permission;

import java.util.List;

public interface PermissionR {
    List<Permission> findAll();

    Permission findById(Integer id);

    boolean save(Permission permission);

    boolean update(Permission permission, Integer id);

    boolean deleteById(Integer id);
}
