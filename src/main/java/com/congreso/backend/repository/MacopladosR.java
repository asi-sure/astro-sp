package com.congreso.backend.repository;

import com.congreso.backend.entities.forms.DacopladosForms;
import com.congreso.backend.entities.forms.MacopladosForms2;
import com.congreso.backend.model.dto.MacopladosDto;

import java.util.List;

public interface MacopladosR {
    MacopladosForms2 findByCoda(String coda);
    String save_Macoplados(MacopladosDto obj);
    void save_Dacoplados(List<DacopladosForms> obj, String coda);
}
