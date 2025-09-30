package com.congreso.backend.repository;

import com.congreso.backend.model.General;
import com.congreso.backend.model.Persons;

public interface GeneralR {
    General findById(int id);
    boolean update_contratos();

}
