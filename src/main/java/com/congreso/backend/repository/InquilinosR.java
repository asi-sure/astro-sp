package com.congreso.backend.repository;

import com.congreso.backend.model.dto.PersonsDto;
import com.congreso.backend.model.forms.InquilinosForm;

import java.util.List;

public interface InquilinosR {

    List<InquilinosForm> findAll(boolean xestado);

}
