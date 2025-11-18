package com.congreso.backend.repository;

import com.congreso.backend.entities.forms.DcontratosForms;
import com.congreso.backend.entities.forms.McontratosForms;
import com.congreso.backend.entities.forms.McontratosForms2;
import com.congreso.backend.model.dto.McontratosDto;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;
import java.util.Optional;

public interface McontratosR {
    McontratosForms2 findByCodcon(String codcon);
    String save_Mcontratos(McontratosDto obj);
    void save_Dcontratos(List<DcontratosForms> obj, String codcon);

}
