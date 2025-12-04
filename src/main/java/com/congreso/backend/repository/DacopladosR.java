package com.congreso.backend.repository;

import com.congreso.backend.model.Dacoplados;
import com.congreso.backend.model.Dcontratos;

import java.util.List;

public interface DacopladosR {
    List<Dacoplados> findByCoda(String coda);
}
