package com.congreso.backend.repository;

import com.congreso.backend.entities.forms.DcontratosForms;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.model.dto.McontratosDto;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface McontratosR {

    String save_Mcontratos(McontratosDto obj);
    void save_Dcontratos(List<DcontratosForms> obj, String codcon);

}
